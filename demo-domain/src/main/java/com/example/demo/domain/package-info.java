/**
 *
 * 这是核心领域业务,他应该是纯粹且无污染的POJO模型,领域层是核心的,不依赖于其他任何层.<br/>
 * aggregate: 领域模型中的聚合根,包的命名规范以聚合根的根对象作为包名, 包含entity, valueobject, factory, converter, repository, rule等子.<br/>
 * gateway: COLA demo中将repository接口重命名为gateway,并集中放置在gateway包中.个人认为可以将repository放在聚合根内表达,两种方式都可以.<br/>
 * seedwork: 适⽤于领域模型的可重⽤基类和接⼝,此文件夹包含可以用作域实体和值对象的基础的自定义基类.使用这些基类,从而在每个领域的对象类中避免冗余代码.<br/>
 * service: 领域模型中的DomainService, DomainService是完成聚合根内单个对象无法表达的领域业务场景.于此区别的是,app层的Service,完成Client的业务流程而非领域内业务规则.<br/>
 * @author mark.liu
 */
package com.example.demo.domain;