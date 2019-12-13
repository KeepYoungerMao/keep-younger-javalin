### JACKSON 问题归纳
###### 报错：
    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: 
    
    Cannot construct instance of `com.mao.XX.XXX` (no Creators, like default construct, exist): 
    
    cannot deserialize from Object value (no delegate- or property-based Creator)
###### 大意为：
    不能构造这个类的实例：因为没有发现（像默认构造）构造器存在。因此无法发序列化：没有构造器
###### 解析：
    就是没有找到无参构造
    由于我是用了`lombok`，在需要转化的类上的注解为：
    @Getter 、 @Setter 、 @AllArgsConstructor
    不使用`lombok`的时候我们知道一个类是自带无参构造的。但是当你使用`lombok`的时候，
    使用了@AllArgsConstructor但是没有使用 @NoArgsConstructor ，编译后的class就没有无参构造。
    也就是`lombok`看你只加了@AllArgsConstructor就不会帮你自动加上无参构造。
###### 解决：
    加上@AllArgsConstructor就可以了