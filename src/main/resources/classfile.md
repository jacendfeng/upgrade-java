javap 的 -v 选项的输出分为几大块。
1. 基本信息，涵盖了原 class 文件的相关信息。class 文件的版本号
（minor version: 0，major version: 54），该类的访问权限
（flags: (0x0021) ACC_PUBLIC, ACC_SUPER），
该类（this_class: #7）以及父类（super_class: #8）的名字，所实现接口（interfaces: 0）、
字段（fields: 4）、方法（methods: 2）以及属性（attributes: 1）的数目。


2. 常量池，用来存放各种常量以及符号引用。

3. 字段区域，用来列举该类中的各个字段。

4. 方法区域，用来列举该类中的各个方法