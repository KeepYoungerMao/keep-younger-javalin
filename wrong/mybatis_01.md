### Mybatis问题归纳
###### 警告：
    WARNING: An illegal reflective access operation has occurred
    
    WARNING: Illegal reflective access by org.apache.ibatis.reflection.Reflector (file:/C:/Users/XXX/.m2/repository/org/mybatis/mybatis/3.4.5/mybatis-3.4.5.jar) to method java.lang.Object.finalize()
    
    WARNING: Please consider reporting this to the maintainers of org.apache.ibatis.reflection.Reflector
    
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    
    WARNING: All illegal access operations will be denied in a future release
###### 解释：
    大意为：mybatis的反射是非法的。这是java内部的警告。
    
    mybatis在使用java中的finalize方法是非法反射访问。以后的版本中对于非法反射访问将会被拒绝。
    
    自java9以上后，可能在反射机制上将要做出改动或优化。并将制定一些正规的使用反射的操作方式。对于现在的不正规的反射方式予以警告。
###### 解决：
    mybatis 5.+ 版本将不会警告此信息。如果想使用java9以上的版本。请将mybatis进行升级。
    
    或者你可以将java版本指定为1.8，也不会报此警告。