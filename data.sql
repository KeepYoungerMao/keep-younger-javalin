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

-- 佛经

CREATE TABLE `tt_buddhist_sutra_class` (
  `bs_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bs_name` varchar(50) DEFAULT NULL COMMENT 'name',
  `bs_image` varchar(100) DEFAULT NULL COMMENT 'image',
  `bs_intro` varchar(500) DEFAULT NULL COMMENT '介绍',
  `bs_type` varchar(50) DEFAULT NULL COMMENT '种类',
  PRIMARY KEY (`bs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO tt_buddhist_sutra_class(bs_name,bs_image,bs_intro,bs_type) VALUES
('四十二章经','sse.jpg','四十二章经很好看','经典佛经'),
('心经','xj.jpg','心经很好看','净土五经');

CREATE TABLE `tt_buddhist_sutra` (
  `bs_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bs_s_id` bigint(10) DEFAULT NULL COMMENT '源id',
  `bs_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `bs_src` mediumtext COMMENT 'src',
  PRIMARY KEY (`bs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO tt_buddhist_sutra(bs_s_id,bs_title,bs_src) VALUES
(1,'四十二章经全文','四十二章经全文是一部佛经。'),
(2,'心经（上）','心经是一部佛经，大多数人都知道。'),
(2,'心经（下）','心经是一部佛经，大多数人都知道。');

-- 百家姓

CREATE TABLE `tt_bjx` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT 'name',
  `py` varchar(10) DEFAULT NULL COMMENT 'py',
  `src` text COMMENT 'src',
  PRIMARY KEY (`bj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tt_bjx`(`name`,`py`,`src`) VALUES
('赵','Z','<p>姓氏：赵</p><p>赵钱孙李，周吴郑王。赵为第一姓氏。</p>'),
('钱','Q','<p>姓氏：钱</p><p>赵钱孙李，周吴郑王。钱为第二姓氏。</p>'),
('孙','S','<p>姓氏：孙</p><p>赵钱孙李，周吴郑王。孙为第三姓氏。</p>'),
('李','L','<p>姓氏：李</p><p>赵钱孙李，周吴郑王。李为第四姓氏。</p>');

-- 古籍

CREATE TABLE `tt_book` (
  `boo_id` bigint(20) NOT NULL COMMENT '主键',
  `boo_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `boo_auth` varchar(50) DEFAULT NULL COMMENT '作者',
  `boo_image` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `boo_s_image` varchar(100) DEFAULT NULL COMMENT '缩略图路径',
  `boo_intro` text COMMENT '介绍',
  `boo_type` varchar(20) DEFAULT NULL COMMENT '书籍类型',
  `boo_type_id` bigint(4) DEFAULT NULL COMMENT '类型id',
  `boo_dynasty` varchar(20) DEFAULT NULL COMMENT '所著年代',
  `boo_dynasty_id` bigint(4) DEFAULT NULL COMMENT '年代id',
  PRIMARY KEY (`boo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tt_book(boo_id,boo_name,boo_auth,boo_image,boo_s_image,boo_intro,boo_type,boo_type_id,boo_dynasty,boo_dynasty_id) VALUES
(1,'三十六计','陈寿','1.jpg','101.jpg','三十六计是一本好书','军事',4,'清朝',14),
(2,'宋史','黄石公','2.jpg','202.jpg','宋史是一本好书','史记',5,'西晋',5),
(3,'聊斋志异','刘义庆','3.jpg','303.jpg','聊斋志异是一本好书','神魔',6,'明朝',13),
(4,'西游记','罗贯中','4.jpg','404.jpg','西游记是一本好书','传记',1,'南宋',10);

CREATE TABLE `tt_chapter` (
  `cha_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cha_cha_id` bigint(10) DEFAULT NULL COMMENT '章节id',
  `cha_name` varchar(50) DEFAULT NULL COMMENT '章节名称',
  `cha_book_id` bigint(10) DEFAULT NULL COMMENT '所属书id',
  `cha_src_id` bigint(10) DEFAULT NULL COMMENT '章节内容id',
  PRIMARY KEY (`cha_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO tt_chapter(cha_cha_id,cha_name,cha_book_id,cha_src_id) VALUES
(1,'三十六计全文',1,1),
(1,'宋史全文',2,2),
(1,'聊斋志异全文',3,3),
(1,'西游记全文',4,4);

CREATE TABLE `tt_chapter_src` (
  `tcr_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tcr_intro` mediumtext COMMENT '章节内容',
  PRIMARY KEY (`tcr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO tt_chapter_src(tcr_intro) VALUES
('<p>三十六计全文</p>'),
('<p>宋史全文</p>'),
('<p>聊斋志异全文</p>'),
('<p>西游记全文</p>');