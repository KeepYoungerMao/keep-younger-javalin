/*
 * 本项目使用数据库：younger
 * 此文件给出项目中使用的表结构，并举例一些数据
 */

-- 关于/反馈： zz_feedback

CREATE TABLE `zz_feedback` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `advise` varchar(200) DEFAULT NULL COMMENT '建议',
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 射线/电视 ：tt_live_m3u8

CREATE TABLE `tt_live_m3u8` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `type` tinyint(1) DEFAULT '0' COMMENT '0国内；1国外',
  `kind` varchar(10) DEFAULT NULL COMMENT '类型：高清，普清',
  `useful` tinyint(1) DEFAULT '1' COMMENT '是否有用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tt_live_m3u8`(`id`,`name`,`url`,`type`,`kind`,`useful`) values
(1,'CCTV-1综合','http://ivi.bupt.edu.cn/hls/cctv1.m3u8',0,'普清',1),
(2,'CCTV-2财经','http://ivi.bupt.edu.cn/hls/cctv2.m3u8',0,'普清',1),
(3,'台 喵咪','https://d3kw4vhbdpgtqk.cloudfront.net/hls/miaomipcweb/prog_index.m3u8',1,'普清',1),
(4,'港凤凰资讯','http://45.126.83.51/qwr9ew/s/s21/index2.m3u8',1,'普清',1);

-- 斑斓/图片： tt_pic , tt_pic_main_class , tt_pic_sub_class
-- 测试图片由百度搜索得到，测试使用。实际项目中地址为本地拼凑地址，实际使用必会报错，请以项目为准更改图片地址。
-- 如：一组数据为：(1,'test',1,1,'test.jpg','test.jpg','test')
-- 如：Main方法中配置的静态地址为："D:\image"，那么该图片的储存地址为：D:\image\1\1\test.jpg
-- 你也可以修改项目，变为直连地址。

CREATE TABLE `tt_pic` (
  `pic_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pic_name` varchar(100) DEFAULT NULL COMMENT 'name',
  `pic_main_class` bigint(5) DEFAULT NULL COMMENT '一级分类',
  `pic_sub_class` bigint(5) DEFAULT NULL COMMENT '二级分类',
  `pic_s_image` varchar(200) DEFAULT NULL COMMENT '小图片',
  `pic_b_image` varchar(200) DEFAULT NULL COMMENT '大图片',
  `pic_key` varchar(500) DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tt_pic`(`pic_id`,`pic_name`,`pic_main_class`,`pic_sub_class`,`pic_s_image`,`pic_b_image`,`pic_key`) VALUES
(1,'呆萌的哈士奇狗狗图片',1,1,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','狗狗图片,哈士奇图片,哈士奇,动物图片'),
(2,'呆萌的藏獒狗狗图片',1,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','狗狗图片,藏獒图片,藏獒,动物图片'),
(3,'呆萌的贵宾犬狗狗图片',1,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','狗狗图片,贵宾犬图片,贵宾犬,动物图片'),
(4,'呆萌的松狮狗狗图片',1,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','狗狗图片,松狮图片,松狮,动物图片'),
(5,'呆萌的哈士奇狗狗图片',1,1,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','狗狗图片,哈士奇图片,哈士奇,动物图片'),
(6,'呆萌的藏獒狗狗图片',1,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','狗狗图片,藏獒图片,藏獒,动物图片'),
(7,'呆萌的贵宾犬狗狗图片',1,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','狗狗图片,贵宾犬图片,贵宾犬,动物图片'),
(8,'呆萌的松狮狗狗图片',1,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','狗狗图片,松狮图片,松狮,动物图片'),
(9,'暹罗猫图片',1,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','猫,暹罗猫,猫猫图片,动物图片'),
(10,'布偶猫图片',1,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','猫,布偶猫,猫猫图片,动物图片'),
(11,'苏格兰折耳猫图片',1,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','猫,苏格兰折耳猫,猫猫图片,动物图片'),
(12,'英国短毛猫图片',1,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','猫,英国短毛猫,猫猫图片,动物图片'),
(13,'暹罗猫图片',1,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','猫,暹罗猫,猫猫图片,动物图片'),
(14,'布偶猫图片',1,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','猫,布偶猫,猫猫图片,动物图片'),
(15,'苏格兰折耳猫图片',1,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','猫,苏格兰折耳猫,猫猫图片,动物图片'),
(16,'英国短毛猫图片',1,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','猫,英国短毛猫,猫猫图片,动物图片'),
(17,'呆萌的哈士奇狗狗图片',2,1,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','狗狗图片,哈士奇图片,哈士奇,动物图片'),
(18,'呆萌的藏獒狗狗图片',2,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','狗狗图片,藏獒图片,藏獒,动物图片'),
(19,'呆萌的贵宾犬狗狗图片',2,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','狗狗图片,贵宾犬图片,贵宾犬,动物图片'),
(20,'呆萌的松狮狗狗图片',2,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','狗狗图片,松狮图片,松狮,动物图片'),
(21,'呆萌的哈士奇狗狗图片',2,1,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2300875363,445064071&fm=5','狗狗图片,哈士奇图片,哈士奇,动物图片'),
(22,'呆萌的藏獒狗狗图片',2,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1794064296,746211315&fm=5','狗狗图片,藏獒图片,藏獒,动物图片'),
(23,'呆萌的贵宾犬狗狗图片',2,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2152435263,329091142&fm=5','狗狗图片,贵宾犬图片,贵宾犬,动物图片'),
(24,'呆萌的松狮狗狗图片',2,1,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=942120003,4005302423&fm=5','狗狗图片,松狮图片,松狮,动物图片'),
(25,'暹罗猫图片',2,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','猫,暹罗猫,猫猫图片,动物图片'),
(26,'布偶猫图片',2,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','猫,布偶猫,猫猫图片,动物图片'),
(27,'苏格兰折耳猫图片',2,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','猫,苏格兰折耳猫,猫猫图片,动物图片'),
(28,'英国短毛猫图片',2,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','猫,英国短毛猫,猫猫图片,动物图片'),
(29,'暹罗猫图片',2,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2333090299,850498900&fm=5','猫,暹罗猫,猫猫图片,动物图片'),
(30,'布偶猫图片',2,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2247692397,1189743173&fm=5','猫,布偶猫,猫猫图片,动物图片'),
(31,'苏格兰折耳猫图片',2,2,'https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1569462993,172008204&fm=5','猫,苏格兰折耳猫,猫猫图片,动物图片'),
(32,'英国短毛猫图片',2,2,'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1667994205,255365672&fm=5','猫,英国短毛猫,猫猫图片,动物图片');

CREATE TABLE `tt_pic_main_class` (
  `pcm_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pcm_name` varchar(20) DEFAULT NULL COMMENT 'name',
  PRIMARY KEY (`pcm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tt_pic_main_class`(`pcm_id`,`pcm_name`) VALUES
(1,'动物图片'),
(2,'动物图图');

CREATE TABLE `tt_pic_sub_class` (
  `pcs_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pcs_p_id` bigint(10) DEFAULT NULL COMMENT 'tt_pic_main_class id',
  `pcs_name` varchar(20) DEFAULT NULL COMMENT 'name',
  PRIMARY KEY (`pcs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tt_pic_sub_class`(`pcs_id`,`pcs_p_id`,`pcs_name`) VALUES
(1,1,'狗狗图片'),
(2,1,'猫咪图片'),
(3,2,'狗狗图图'),
(4,2,'猫咪图图');
