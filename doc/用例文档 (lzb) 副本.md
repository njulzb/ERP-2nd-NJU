

[TOC]


# 进销存系统用例文档 #

----------

**文档修改信息：**


| 版本号  | 修改人员            | 修改时间                  | 修改原因                                     |
| ---- | --------------- | --------------------- | ---------------------------------------- |
| v1.0 | lzb，lyb，mxf，hqj | 9/16/2017 12:05:10 PM | 文档初稿                                     |
| v1.1 | lzb             | 10/12/2017 8:39:26 PM | 增加文档封面，目录，修改编号，修改用例1-7                   |
| v1.2 | 李一冰             | 10/12/2017 10:44 PM   | 1.新增了红冲用例，单据审批用例，同时补充了建账用例和库存报警单用例；<br/>2.测试性使用TOC，为每个用例添加单独的header，方便toc进行索引 |
| v2.1 | lzb             | 2018-1-8 16:04        | 1. 对库存人员部分用例进行修改，做最后的定稿                  |
----------

## 目录： ##
1. 引言
2. 用例列表
3. 详细用例描述

## 1.引言 ##
### 1.1目的 ###
本文档描述了进销存系统的用户需求
### 1.2阅读说明 ###
本文档参考了MSCS用例文档
### 1.3参考文献 ###
MSCS用例文档


## 2.用例列表： ##


| 参与者    | 用例                                       |
| ------ | ---------------------------------------- |
| 库存管理人员 | 1. 商品分类管理<br/>2.商品管理<br/>3.库存查看<br/>4.库存盘点<br/>5.库存赠送单<br/>6.库存报溢单<br/>7.库存报损单<br/>8.库存报警单 |
| 进货销售人员 | 9.制定销售退货单<br/>10.制定进货单<br/>11.制定退货单<br/>12.制定销售单<br/>13.制定销售退货单<br/> |
| 财务人员   | 14.账户管理<br/>15.制定收款单<br/>16.制定付款单<br/>17.制定销售明细表<br/>18.查看经营历程表<br/>19.查看经营情况表<br/>20.期初建账<br/>21.红冲与红冲并复制 |
| 总经理    | 22.制定销售策略<br/>23.客户管理<br/>24.单据审批        |




## 3.详细用例描述 ##

### 3.1 商品分类管理

| ID   | 1                     | 名称     | 商品分类管理         |
| ---- | --------------------- | ------ | -------------- |
| 创建者  | lzb                   | 最后更新者  | lzb            |
| 创建日期 | 9/16/2017 12:38:21 PM | 最后更新日期 | 2018-1-8 16:04 |

| 参与者  | 库存管理人员，目标是对商品分类进行严格的管理，以进一步对商品进行严格的管理    |
| ---- | ---------------------------------------- |
| 触发条件 | 管理人员发起请求（增删改查）                           |
| 前置条件 | 管理人员登陆完毕，获得授权                            |
| 后置条件 | 保存修改后的分类及其编号                             |
| 优先级  | 高                                        |
| 正常流程 | 1. 人员发起管理分类请求                                               <br/> 2.系统显示分类管理界面                                                 <br/> 3.人员选择分类                                                         <br/> 4.系统显示分类信息                                                 <br/> 5.人员选择操作（增删改）                                                                                  <br/> 6.人员确认操作                                                         <br/> 7. 系统存储信息，并自动分配编号 <br/> 8. 用户输入商品分类id搜索<br/> 9. 系统返回满足条件的商品分类<br/> |
| 扩展流程 | 5a.修改分类时，信息不完善，提示管理人员，不存储<br/>5b.若是新建分类，则显示新建界面，等待用户输入信息                       <br/>6a.人员取消操作，系统返回，不作修改<br/>6b.向有商品的叶节点的分类添加分类，提示操作非法，系统返回，不作修改 |
| 特殊需求 | 无                                        |



----------

<br/>

### 3.2 商品管理

<br/>

| ID   | 2                    | 名称     | 商品管理           |
| ---- | -------------------- | ------ | -------------- |
| 创建者  | lzb                  | 最后更新者  | lzb            |
| 创建日期 | 9/16/2017 1:03:31 PM | 最后更新日期 | 2018-1-8 16:14 |

| 参与者  | 库存管理人员 ，目标是对商品进行更严格的分类和管理                |
| ---- | ---------------------------------------- |
| 触发条件 | 管理人员发起请求(增删改查)                           |
| 前置条件 | 管理人员登录完毕，并取得授权                           |
| 后置条件 | 系统存储修改后的信息                               |
| 优先级  | 高                                        |
| 正常流程 | 增加：                    <br/>1. 人员发起新增请求<br/>2. 系统显示新增界面<br/>3. 人员填入商品信息，并确认<br/>4.  系统返回生成结果，新的商品序列<br/><br/>删除：<br/>1. 人员点击商品<br/>2. 人员选择删除操作并确认<br/>3. 系统删除选定商品，并返回删除结果，新的商品序列<br/><br/>修改：<br/>1. 人员选定商品<br/>2. 系统显示商品详细信息<br/>3. 人员修改信息并确认<br/>4. 系统返回修改结果<br/><br/>查询：<br/>1.输入关键字或商品编号<br/>2.系统返回满足条件的商品序列 |
| 扩展流程 | a.每一步的选定取消，系统返回不作修改<br/>增加：若新增商品的父类不是叶节点，系统拒绝加入，并提示用户<br/>修改：若用户最终修改的信息不完善，系统拒绝修改，并提示用户<br/> |
| 特殊需求 | 无                                        |

----------

<br/>

### 3.3 库存查看

<br/>


| ID   | 3                     | 名称     | 库存查看           |
| ---- | --------------------- | ------ | -------------- |
| 创建者  | lzb                   | 最后更新者  | lzb            |
| 创建日期 | 9/17/2017 12:06:29 PM | 最后更新日期 | 2018-1-8 16:26 |

| 参与者  | 库存管理人员，目标是了解一段时间内库存进出状况，以掌握出入库情况         |
| ---- | ---------------------------------------- |
| 触发条件 | 库存管理人员发起请求                               |
| 前置条件 | 人员登录完毕并取得授权                              |
| 后置条件 |                                          |
| 优先级  | 高                                        |
| 正常流程 | 1.人员设定时间段，并确认查询<br/>2.系统返回时间段内的出入库数量及金额，销售进出货量及金额，及库存数量合计。 |
| 扩展流程 | 1a.时间段不符合要求（开始时间大于结束时间）              <br/> 2.系统提示输入不合法，清空用户输入，等待用户继续输入 |
| 特殊需求 | 无                                        |

----------

<br/>

### 3.4 库存盘点

<br/>


| ID   | 4                     | 名称     | 库存盘点                  |
| ---- | --------------------- | ------ | --------------------- |
| 创建者  | lzb                   | 最后更新者  | lzb                   |
| 创建日期 | 9/17/2017 12:13:03 PM | 最后更新日期 | 10/12/2017 9:06:06 PM |

| 参与者  | 库存管理人员 ，目标是对当天的库存进行查看，以及时发现情况            |
| ---- | ---------------------------------------- |
| 触发条件 | 库存管理人员发起请求                               |
| 前置条件 | 人员登录完毕并取得授权                              |
| 后置条件 | 无                                        |
| 优先级  | 高                                        |
| 正常流程 | 1.人员确认查询<br/>2.系统返回当天各种产品的名称，型号，库存数量，库存均价，批次，批号，出厂日期<br/> |
| 扩展流程 | 无                                        |
| 特殊需求 | 1.显示行号<br/>2.可以导出Excel                   |

----------

<br/>

### 3.5 库存赠送单

<br/>


| ID   | 5                    | 名称     | 库存赠送单          |
| ---- | -------------------- | ------ | -------------- |
| 创建者  | lzb                  | 最后更新者  | lzb            |
| 创建日期 | 9/17/2017 4:49:37 PM | 最后更新日期 | 2018-1-8 16：31 |

| 参与者  | 总经理，目标是根据促销策略完成库存赠送单的生成及出货；<br/>库存管理人员，目标是根据库存赠送单完成出货任务 |
| ---- | ---------------------------------------- |
| 触发条件 | 总经理发起生成赠送单请求                             |
| 前置条件 | 促销策略生成完毕，人员登录完毕并取得授权                     |
| 后置条件 | 无                                        |
| 优先级  | 中                                        |
| 正常流程 | 1.总经理发起生成赠送单请求                                         <br/>2.系统显示赠送单界面，根据促销策略规定的赠送列表制定                                                     <br/>3.总经理审批                                                  <br/>4.审批通过后发送给库存管理人员                                  <br/>5.系统自动从库存中减去这些商品                                <br/>6.库存管理人员发货 |
| 扩展流程 | 无                                        |
| 特殊需求 | 1.显示行号<br/>2.可以导出Excel                   |



----------

<br/>

### 3.6 库存报溢单

<br/>


| ID   | 6                    | 名称     | 库存报溢单                 |
| ---- | -------------------- | ------ | --------------------- |
| 创建者  | lzb                  | 最后更新者  | lzb                   |
| 创建日期 | 9/17/2017 4:58:45 PM | 最后更新日期 | 10/12/2017 9:17:42 PM |

| 参与者  | 库存管理人员，目标是根据仓库中的实际情况，更新系统中库存商品的数量信息      |
| ---- | ---------------------------------------- |
| 触发条件 | 库存实际商品数量大于系统中商品数量                        |
| 前置条件 | 人员登录完毕并取得授权                              |
| 后置条件 | 库存商品数量与系统商品数量一致                          |
| 优先级  | 中                                        |
| 正常流程 | 1.人员发起报溢请求                                     <br/>2.系统显示报溢界面                                               <br/>3.人员填写报溢表                                              <br/>4.系统保存表单信息                                                          <br/>5.人员提交报溢表，等待总经理审批<br/>6. 总经理审批通过后，自动修改系统中的商品数量 |
| 扩展流程 | 3a.人员填写信息不完全或存在不合法的信息项                <br/> 4.系统提示单据中信息不完全或不合法的信息项，不保存单据 |
| 特殊需求 | 无                                        |

----------

<br/>

### 3.7 库存报损单

<br/>


| ID   | 7                    | 名称     | 库存报损单                |
| ---- | -------------------- | ------ | -------------------- |
| 创建者  | lzb                  | 最后更新者  | lzb                  |
| 创建日期 | 9/17/2017 5:10:12 PM | 最后更新日期 | 9/23/2017 4:45:39 PM |

| 参与者  | 库存管理人员，目标是根据仓库中的实际情况，更新系统中库存商品的数量信息      |
| ---- | ---------------------------------------- |
| 触发条件 | 库存实际商品数量小于系统中商品数量                        |
| 前置条件 | 人员登录完毕并取得授权                              |
| 后置条件 | 库存商品数量与系统商品数量一致                          |
| 优先级  | 中                                        |
| 正常流程 | 1.人员发起报损请求                                    <br/>2.系统显示报损界面                                             <br/>3.人员填写报损单                                                  <br/>4.系统保存报损单为草稿状态                                         <br/>5.人员提交报损单                                               <br/>6.系统保存单据为提交状态，等待总经理审批<br/>7. 审批通过后，自动修改系统中的商品数量 |
| 扩展流程 | 3a.人员填写信息不完全或存在不合法的信息项                <br/> 4.系统提示单据中信息不完全或不合法的信息项，不保存单据 |
| 特殊需求 | 无                                        |

----------

<br/>

### 3.8 库存报警单

<br/>


| ID   | 8                    | 名称     | 库存报警单            |
| ---- | -------------------- | ------ | ---------------- |
| 创建者  | lzb                  | 最后更新者  | 李一冰              |
| 创建日期 | 9/17/2017 5:11:20 PM | 最后更新日期 | 10/12/2017 21:55 |

| 参与者  | 库存管理人员，目的是使商品数量维持在一个稳定的范围                |
| ---- | ---------------------------------------- |
| 触发条件 | 某销售出货单通过审批后生效                            |
| 前置条件 | 人员登录完毕并取得授权                              |
| 后置条件 | 无                                        |
| 优先级  | 中                                        |
| 正常流程 | 1.系统检测到商品数量低于警戒值   <br/>2.系统向库存管理人员发出“XX商品数量不足XXX件”的报警信息，同时自动生成一张库存报警单，填入该商品名称、编号、  现有数量，警戒数量 ，并报请总经理审批 <br/>3.总经理审批通过后，库存管理人员接到消息开始完成现实操作 |
| 扩展流程 | 无                                        |
| 特殊需求 | 无                                        |




<br/>

### 3.9 制定销售退货单

<br/>


| ID   | 9         | 名称     | 制定销售退货单   |
| ---- | --------- | ------ | --------- |
| 创建者  | 洪铨健       | 最后更新者  | 李一冰       |
| 创建日期 | 2017/9/16 | 最后更新日期 | 2017/9/25 |

| 参与者  | 进货销售人员，目标是制定销售退货单                        |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 触发条件 | 进货销售人员必须已经被识别和授权                         |
| 前置条件 | 无                                        |
| 后置条件 | 无                                        |
| 正常流程 | 1.进货销售人员新建一个销售退货单<br/>2.进货销售人员填写销售退货单据编号，供应商，仓库，操作员，入库商品列表(从商品选择界面选择名称和填写数量，单价，备注)，备注，总额合计<br/>3.系统计算、填充销售退货单<br/>4.进货销售人员提交进货退货单 |
| 扩展流程 | 2a.非法单据编号：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并拒绝输入<br/>2b.单据个数超过99999：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示溢出并反馈给销售经理<br/>3a.单据数据不全：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并提示缺少数据<br/> |
| 特殊需求 | 单据编号格式为：JHTHD-yyyyMMdd-xxxxx，后五位每天从1开始编号 |


<br/>

### 3.10 制定进货单

<br/>


| ID   | 10        | 名称     | 制定进货单     |
| ---- | --------- | ------ | --------- |
| 创建者  | 洪铨健       | 最后更新者  | 洪铨健       |
| 创建日期 | 2017/9/16 | 最后更新日期 | 2017/9/16 |

| 参与者  | 进货销售人员，目标是快速、正确新建一个进货单                   |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 触发条件 | 无                                        |
| 前置条件 | 进货销售人员必须已经被识别和授权                         |
| 后置条件 | 等待订单审核，更改库存数据和客户的应收应付数据                  |
| 正常流程 | 1.进货销售人员新建一个进货单<br/>2.进货销售人员填写单据编号，供应商，仓库，操作员，入库商品列表(从商品选择界面选择名称和填写数量，单价，备注)，备注，总额合计<br/>3.系统计算、填充进货单<br/>4.进货销售人员提交进货单 |
| 扩展流程 | 2a.非法单据编号：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并拒绝输入<br/>2b.单据个数超过99999：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示溢出并反馈给销售经理<br/>3a.单据数据不全：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并提示缺少数据<br/> |
| 特殊需求 | 单据编号格式为：JHD-yyyyMMdd-xxxxx，后五位每天从1开始编号   |



<br/>

### 3.11 制定进货退货单

<br/>




| ID   | 11        | 名称     | 制定进货退货单   |
| ---- | --------- | ------ | --------- |
| 创建者  | 洪铨健       | 最后更新者  | 洪铨健       |
| 创建日期 | 2017/9/17 | 最后更新日期 | 2017/9/17 |

| 参与者  | 进货销售人员，目标是快速、正确新建一个进货退货单                 |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 触发条件 | 无                                        |
| 前置条件 | 进货销售人员必须已经被识别和授权                         |
| 后置条件 | 等待订单审核，更改库存数据和客户的应收应付数据                  |
| 正常流程 | 1.进货销售人员新建一个进货退货单<br/>2.进货销售人员填写进货退货单据编号，供应商，仓库，操作员，入库商品列表(从商品选择界面选择名称和填写数量，单价，备注)，备注，总额合计<br/>3.系统计算、填充进货退货单<br/>4.进货销售人员提交进货退货单 |
| 扩展流程 | 2a.非法单据编号：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并拒绝输入<br/>2b.单据个数超过99999：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示溢出并反馈给销售经理<br/>3a.单据数据不全：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并提示缺少数据<br/> |
| 特殊需求 | 单据编号格式为：JHTHD-yyyyMMdd-xxxxx，后五位每天从1开始编号 |


<br/>

### 3.12 制定销售单

<br/>




| ID   | 12        | 名称     | 制定销售单     |
| ---- | --------- | ------ | --------- |
| 创建者  | 洪铨健       | 最后更新者  | 洪铨健       |
| 创建日期 | 2017/9/17 | 最后更新日期 | 2017/9/17 |

| 参与者  | 进货销售人员，目标是快速、正确新建一个销售出货单                 |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 触发条件 | 无                                        |
| 前置条件 | 进货销售人员必须已经被识别和授权                         |
| 后置条件 | 等待订单审核，更改库存数据和客户的应收应付数据                  |
| 正常流程 | 1.进货销售人员新建一个销售出货单<br/>2.进货销售人员填写销售出货单据编号，客户，业务员，操作员，仓库，出货商品清单(从商品选择界面选择名称和填写数量，单价，商品备注)，折让前总额，折让，折让后总额，备注<br/>3.系统计算、填充销售出货单<br/>4.进货销售人员提交销售出货单 |
| 扩展流程 | 2a.非法单据编号：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并拒绝输入<br/>2b.单据个数超过99999：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示溢出并反馈给销售经理<br/>3a.单据数据不全：<br/>&nbsp;&nbsp;&nbsp;&nbsp;1.系统提示错误并提示缺少数据<br/> |
| 特殊需求 | 1.单据编号格式为：XSD-yyyyMMdd-xxxxx，后五位每天从1开始编号<br/>2.销售员最多折让1000元，销售经理可以折让5000元，总经理可以任意金额的折让 |



<br/>

### 3.13 制定收款单

<br/>



<br>

| ID   | 13                  | 名称     | 制定收款单             |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |



<br/>

| 用例名称 | 制定收款单                                    |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员，目的是向某客户进行收款                         |
| 触发条件 | 某笔交易进入收款阶段                               |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志；单据报请总经理审核                         |
| 正常流程 | 1.财务选择制定收款单<br/>2.系统生成一张空白收款单并自动填入编号与操作员<br/>3.财务人员选择客户<br/>4.财务人员填入一条收款信息<br/>5.系统根据现有转账信息计算总额<br/>重复4、5直到所有转账信息都被填入<br/>5.财务点击提交<br/>6.系统返回现有账目表<br/>7.财务选择一个账目。<br/>8.系统将此单入账并报请审批，同时存储日志与修改相关账户余额信息。<br/>9.总经理审批通过，报表生效 |
| 扩展流程 | 2a.当天已有99999笔交易：<br/>1.系统提示创建失败并返回<br/>5a.财务人员填写金额非法格式<br/>1.系统提示金额非法并返回 |
| 特殊需求 | 无                                        |

<br>


<br/>

### 3.14 制定付款单

<br/>


| ID   | 14                  | 名称     | 制定付款单             |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>


| 用例名称 | 制定付款单                                    |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员，目的是向某客户进行付款                         |
| 触发条件 | 某笔交易进入付款阶段                               |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志；单据报请总经理审核                         |
| 正常流程 | 1.财务选择制定付款单<br/>2.系统生成一张空白付款单并自动填入编号与操作员<br/>3.财务人员选择客户<br/>4.财务人员填入一条付款信息<br/>5.系统根据现有付款信息计算总额<br/>重复4、5直到所有转账信息都被填入<br/>5.财务点击提交<br/>6.系统返回现有账目表<br/>7.财务选择一个账目。<br/>8.系统将此单入账并报请审批，同时存储日志与修改相关账户余额信息。<br/>9.总经理审批通过，报表生效 |
| 扩展流程 | 2a.当天已有99999笔交易：<br/>1.系统提示创建失败并返回<br/>5a.财务人员填写金额非法格式<br/>1.系统提示金额非法并返回回<br/>5b.账户内余额不足时<br/>1.系统提示某一账户余额不足并返回 |
| 特殊需求 | 无                                        |
<br>


<br/>

### 3.15 管理银行账户

<br/>


| ID   | 15                  | 名称     | 管理银行账户            |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>

| 用例名称 | 管理银行账户                                   |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员，目的是对公司的银行账户进行增删改查的管理操作              |
| 触发条件 | 因业务需要，银行账户需要被更改时                         |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志；财务人员完成更改银行账户的现实操作                 |
| 正常流程 | 1.财务选择账户管理<br/>2.系统以5条/页的方式显示所有账户信息，并提供增加账户与查询账户的选项<br/><br/>①增加账户：<br/>1.财务人员选择增加账户<br/>2系统显示提示财务人员输入账户的名称<br/>3.财务人员输入账户名称<br/>4.系统自动将余额设为0并将该账户新增进入账户列表<br/><br/>②查询账户：<br/>1.财务人员选择查询账户<br/>2.系统提示用户输入搜索关键词<br/>3.财务人员输入关键词<br/>4.系统返回所有账户名称中包含关键词的账户<br/><br/>③删除账户：<br/>1.财务人员选择某一账户<br/>2.系统显示该账户的详细信息，并提供修改和删除选项<br/>3.财务人员选择删除<br/>4.系统确认财务人员是否要删除<br/>5.财务人员选择确认<br/>6.系统将该账户从列表中删除<br/><br/>④修改账户信息：<br/>1.财务人员选择某一账户<br/>2.系统返回该账户的详细信息，并提供删除和修改信息选项<br/>3.财务人员选择修改账户信息<br/>4.财务人员修改账户信息<br/>5.系统将新的信息存入 |
| 扩展流程 | ①3a 财务人员输入的账户名称不合法：<br/>系统提示名称不合法并返回<br/>②4a 系统未找到符合条件的账户:<br/>系统显示未找到相关账户<br/>④4a 财务人员输入的信息不合法：<br/>系统提示信息不合法并拒绝操作 |
| 特殊需求 | 无                                        |
<br/>

<br>


<br/>

### 3.16 制定现金费用单

<br/>


| ID   | 16                  | 名称     | 制定现金费用单           |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>


| 用例名称 | 制定现金费用单                                  |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员，目的是报销某些先现金花费                        |
| 触发条件 | 产生了某笔需要报销的现金操作                           |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志；单据报请总经理审核                         |
| 正常流程 | 1.财务选择制定现金费用单<br/>2.系统生成一张空白现金费用单并自动填入编号与操作员<br/>3.财务人员选择客户<br/>4.财务人员填入一条付款信息的条目名金额备注<br/>5.系统根据现有付款信息计算总额<br/>重复4、5直到所有条目信息都被填入<br/>5.财务点击提交<br/>6.系统返回现有账目表<br/>7.财务选择一个账目。<br/>8.系统将此单入账并报请审批，同时存储日志与修改相关账户余额信息。<br/>9.总经理审批通过，报表生效 |
| 扩展流程 | 2a.当天已有99999笔交易：<br/>1.系统提示创建失败并返回<br/>5a.财务人员填写金额非法格式<br/>1.系统提示金额非法并返回<br/>5b.账户内余额不足时<br/>1.系统提示某一账户余额不足并返回 |
| 特殊需求 | 无                                        |
<br/>
<br>


<br/>

### 3.17 查看销售明细表

<br/>


| ID   | 17                  | 名称     | 查看销售明细表           |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>


| 用例名称 | 查看销售明细表                                  |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员或总经理，目的是查看销售的进货与出货情况                 |
| 触发条件 | 无                                        |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志                                   |
| 正常流程 | 1.财务选择查看销售明细表<br/>2.系统以5条每页的格式倒序列出所有销售出货单与销售出货退货单记录，并提供筛选选项<br/><br/>①查询详细信息<br/>1.财务人员选择某一条单据<br/>2.系统显示该单据的详细信息<br/><br/>②筛选：<br/>1.财务人员选择筛选操作<br/>2.系统提示输入时间区间商品名客户业务员仓库等筛选信息<br/>3.财务人员输入相关信息，空信息表示不对该信息筛选<br/>4.系统以5条每页倒序显示所有单据<br/><br/><br/>①导出报表<br/>1.财务人员选择导出报表<br/>2.系统提示选择路径与格式<br/>3.财务人员进行选择<br/>4.系统将报表以指定格式存储到该路径 |
| 扩展流程 | ②4a未找到符合条件的单据：<br/>1.系统提示无信息并返回<br/>     |
| 特殊需求 | 无                                        |
<br/>


<br/>

### 3.18 查看经营历程表

<br/>


| ID   | 18                  | 名称     | 查看经营历程表           |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>

| 用例名称 | 查看经营历程表                                  |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员或总经理，目的是查看所有单据                       |
| 触发条件 | 无                                        |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志                                   |
| 正常流程 | 1.财务选择查看经营历程表<br/>2.系统以5条每页的格式倒序列出所有销售类单据、进货类单据、财务类单据记录，并提供筛选和选项<br/><br/>①筛选：<br/>①1.财务人员选择筛选操作<br/>2.系统提示输入时间区间、单据类型、客户、业务员、仓库等筛选信息<br/>3.财务人员输入相关信息，空信息表示不对该信息筛选<br/>4.系统以5条每页倒序显示所有单据<br/><br/><br/>④导出报表<br/>1.财务人员选择导出报表<br/>2.系统提示选择路径与格式<br/>3.财务人员进行选择<br/>4.系统将报表以指定格式存储到该路径 |
| 扩展流程 | ②4a未找到符合条件的单据：<br/>1.系统提示无信息并返回<br/>     |
| 特殊需求 | 无                                        |
<br/>




<br/>

### 3.19 查看经营情况表
<br/>



| ID   | 19                  | 名称     | 查看经营情况表           |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |



<br/>

| 用例名称 | 查看经营情况表                                  |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员或总经理，目的是查看一定时间内的收入支出利润数据             |
| 触发条件 | 无                                        |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志                                   |
| 正常流程 | 1.财务选择查看经营情况表<br/>2.系统提示财务人员输入时间范围<br/>3.财务人员输入范围<br/>4.系统显示该段时间的收入类支出类数据、计算并显示利润，同时提供导出报表选项<br/><br/>①导出报表<br/>1.财务人员选择导出报表<br/>2.系统提示选择路径与格式<br/>3.财务人员进行选择<br/>4.系统将报表以指定格式存储到该路径 |
| 扩展流程 | 1a财务人员输入了不符合时间顺序的的时间范围或者该范围没有信息：<br/>1.系统提示没有相关信息并返回<br/> |
| 特殊需求 | 无                                        |
<br/>


<br/>

### 3.20 新建账本

<br/>


| ID   | 20                  | 名称     | 新建账本              |
| ---- | ------------------- | ------ | ----------------- |
| 创建者  | 李一冰                 | 最后更新者  | 李一冰               |
| 创建日期 | 2017年9月18日 19:16:00 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>

| 用例名称 | 新建账本                                     |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员，目的是为一个新的经营季度创建一个账目                  |
| 优先级  | 低                                        |
| 触发条件 | 一个新的经营季度开始                               |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志；销售人员完善客户信息；库存管理人员完善商品及其分类信息       |
| 正常流程 | 1.财务选择期初建账<br/>2.系统要求输入有效期<br/> 3.财务人员输入账本有效期 <br/> 4.系统将上一年的商品信息，客户信息，银行账户信息导入作为一个新的账目，在有效期内供信息的增删改查。同时保存这个账目的初始状态<br/> |
| 扩展流程 | 无                                        |
| 特殊需求 | 无                                        |
<br/>




<br/>

### 3.21红冲与红冲并复制

<br/>



| ID   | 21                | 名称     | 红冲与红冲并复制          |
| ---- | ----------------- | ------ | ----------------- |
| 创建者  | 李一冰               | 最后更新者  | 李一冰               |
| 创建日期 | 2017年10月12日 22:07 | 最后更新日期 | 2017年10月12日 22:07 |


<br/>


| 用例名称 | 红冲与红冲并复制                                 |
| ---- | ---------------------------------------- |
| 优先级  | 中                                        |
| 参与者  | 财务人员，目的是删除或修改某条已经入账的单据                   |
| 触发条件 | 检查某单据过程中发现其需要撤销或修改                       |
| 前置条件 | 财务人员已被识别和授权                              |
| 后置条件 | 记录操作日志；单据报请总经理审核                         |
| 正常流程 | ①红冲<br/>1.财务人员选择某一条单据<br/>2.系统显示该单据的详细信息并提供红冲与红冲并复制按钮<br/>3.财务人员选择红冲<br/>4.系统自动生成一张与原表单相同但金额取负的红冲账单并报请总经理审批<br/>4.总经理审批通过，报表生效<br/><br/>②红冲并复制<br/>1.财务人员选择某一条单据<br/>2.系统显示该单据的详细信息并提供红冲与红冲并复制按钮<br/>3.财务人员选择红冲并复制<br/>4.系统自动生成一张与原表单相同但金额取负的红冲账单，同时申请一张新的表单供财务人员填写<br/>5.财务人员填写相关信<br/>6.系统将两张报单一起交由总经理审批<br/> |
| 扩展流程 | 无                                        |
| 特殊需求 | 无                                        |

<br/>


<br/>

### 3.22 制定销售策略

<br/>







| ID   | 22        | 名称     | 制定销售策略    |
| ---- | --------- | ------ | --------- |
| 创建者  | mxf       | 最后更新者  | mxf       |
| 创建日期 | 2017/9/18 | 最后更新日期 | 2017/9/18 |

| 参与者  | 总经理，目标是根据最新的市场状况调整销售商品。                  |
| ---- | ---------------------------------------- |
| 触发条件 | 商品厂家提出自己商品的促销要求；节假日或者竞争促销；提前处理有可能会报废的商品；<br>去除现有的销售策略 |
| 前置条件 | 总经理必须已经被识别和授权.                           |
| 后置条件 | 记录销售策略信息.                                |
| 优先级  | 中                                        |
| 正常流程 | 1. 不同用户级别促销策略<br> ---1.1 礼品赠送<br> 1.11. 总经理输入客户编号<br> 1.12. 系统显示客户级别<br> 1.13. 总经理输入赠送商品标识<br> 1.14. 系统显示赠送商品的标识、描述和价格<br> 1.15. 总经理输入赠送数量、起始时间和间隔时间<br> 1.16. 系统显示商品赠送信息列表<br> 总经理重复1.11～1,16步，直到输入所有商品赠送策略<br> 1.17. 总经理结束输入<br> 1.18. 系统记录不同级别用户赠送策略信息 <br><br> ---1.2 赠送代金券<br> 1.21. 总经理输入客户编号<br> 1.22. 系统显示客户级别<br> 1.23.总经理输入代金券信息，包括面值、数量、起始时间、间隔时间 总经理重复1.21～1.23步，直到输入所有代金券策略<br> 1.23. 总经理结束输入<br> 1.24. 系统记录不同级别用户代金券促销信息<br> <br> ---1.3 价格折让<br> 1.31. 总经理输入客户编号<br> 1.32. 系统显示客户级别<br> 1.33. 总经理输入价格折让信息，包括折扣率、起始时间、间隔时间<br> 总经理重复1.31～1.33步，直到输入所有价格折让策略信息<br> 1.23. 总经理结束输入<br> 1.24. 系统记录不同级别用户价格折让策略信息<br> <br> 2. 组合商品特价促销<br> 2.1. 总经理输入商品标识<br> 2.2. 系统显示商品信息，包括商品标识、描述和价格<br> 2.3. 总经理输入商品特价信息，包括特价、起始时间和间隔时间<br> 2.4. 系统显示特价商品列表，包括商品标识、描述、价格、特价、起始时间和间隔时间<br>总经理重复2.1～2.4步，直到输入所有组合商品特价信息<br> 2.5. 总经理结束输入<br> 2.6. 系统记录组合商品特价信息 <br><br> 3. 总价促销策略<br> ---3.1 礼品赠送<br> 3.11. 总经理输入商品标识<br> 3.12. 系统显示商品信息，包括商品标识、描述和价格<br> 3.13. 总经理输入赠送商品标识<br> 3.14. 系统显示赠送商品的标识、描述和价格<br> 3.15. 总经理输入赠送数量、起始时间和间隔时间<br> 3.16. 系统显示商品赠送信息列表<br> 总经理重复3.11～3.16步，直到输入所有商品赠送策略<br> 3.17. 总经理结束输入<br> 3.18. 系统记录总额赠送礼品策略信息 <br><br> ---3.2 赠送代金券<br> 3.21. 总经理输入总额促销信息，包括总额、代金券面值、代金券数量、起始时间和间隔时间<br> 3.22. 系统显示总额促销信息列表<br> 总经理重复3.21～3.22步，直到输入所有总额促销策略<br> 3.23. 总经理结束输入<br> 3.24. 系统记录总额赠送代金券策略信息<br> <br> 4 移除已有促销策略<br> 4.1.系统显示已有促销策略列表<br> 4.2.总经理输入要移除的促销策略<br> 4.3.系统移除该促销策略<br>4.4.系统显示剩下的促销策略列表<br> 总经理重复4.2～4.4步，直到移除所有需要移除的促销策略 |
| 扩展流程 | 1.13a. 非法标识<br> ...1. 系统提示错误并拒绝输入<br>  2.1a. 非法标识<br> ...1. 系统提示错误并拒绝输入<br> 2.3a. 在期间内该商品已有特价<br> ...1. 系统提示已有特价拒绝输入<br> 2.4a. 总经理要移除已输入的商品特价信息<br> ...1. 总经理输入商品标识<br> ...2. 系统移除该商品的特价信息<br> 3.11a. 非法标识<br> ...1. 系统提示错误并拒绝输入<br> <br> |
| 特殊需求 | 无                                        |
------------------

<br/>

### 3.23 客户管理

<br/>



| ID   | 23        | 名称     | 客户管理      |
| ---- | --------- | ------ | --------- |
| 创建者  | mxf       | 最后更新者  | mxf       |
| 创建日期 | 2017/9/18 | 最后更新日期 | 2017/9/18 |

| 参与者  | 进货销售人员，目标是实现对客户信息的管理（包括增删改查）。            |
| ---- | ---------------------------------------- |
| 触发条件 |                                          |
| 前置条件 | 总经理必须已经被识别和授权。                           |
| 后置条件 | 存储不同级别的会员信息。                             |
| 优先级  | 高                                        |
| 正常流程 | 1 增加客户<br> 1.1 系统生成并显示客户编号<br> 1.2. 进货销售人员输入客户信息，包括分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员<br> 1.3. 根据积分将客户分为A、B、C、D、E五个级别<br> 1.4. 系统记录客户信息<br> 1.5. 进货销售人员结束客户信息录入<br>1.6.重复1.1~1.5步直到所有的新客户的信息都添加完毕<br><br>2  删除客户<br> 2.1进货销售人员选择删除操作<br>2.2系统删除指定客户的信息<br>2.3进货销售人员重复2.1~2.2步直到所有需要删除的客户都删除<br><br> 3 修改客户<br>3.1进货销售人员选择需要修改的客户<br>3.2系统显示该客户原有的信息<br>3.2进货销售人员修改指定客户的资料<br>3.3系统存储下被修改客户的新信息<br>3.4重复3.1~3.3直到所有需要被修改的客户信息均被修改完成<br>3.5进货销售人员结束修改<br><br>4  查询客户<br>4.1进货销售人员选择查询操作，并输入相关关键字<br>4.2系统根据关键字显示相关的客户冰显示该客户的信息<br>4.3重复以上操作直至所有需要被查询的客户都被查询完毕<br>4.4进货销售人员结束查询<br><br> 5  应收额度的录入<br> 5.1最高权限决定应收额度的录入<br><br> 6  应收和应付<br> 6.1根据进货单，销售单，收款单和付款单来决定此项数据的大小 |
| 扩展流程 | 无                                        |
| 特殊需求 | 客户编号为5位0~9的数字                            |
----------------------

<br/>

### 3.24 单据审批

<br/>





<br/><br/>

| ID   | 24        | 名称     | 单据审批      |
| ---- | --------- | ------ | --------- |
| 创建者  | mxf       | 最后更新者  | mxf       |
| 创建日期 | 2017/9/18 | 最后更新日期 | 2017/9/18 |

| 参与者  | 总经理，目的是检查审核待审批状态的单据，决定其是否能生效             |
| ---- | ---------------------------------------- |
| 优先级  | 高                                        |
| 触发条件 | 无                                        |
| 前置条件 | 总经理必须已经被识别和授权。 存在处于待审批状态的单据              |
| 后置条件 | 单据生效，根据单据的不同类型修改涉及到的商品信息、客户信息、银行账户信息     |
| 正常流程 | 1.总经理选择“单据审批”<br/>2.系统以5条每页正序显示所有待审批状态的单据<br/>3.总经理选择某一单据<br/>4.系统显示该单据所有信息，并提供编辑、通过、拒绝三个选项<br/><br/><br/>①编辑：<br/>①1.总经理选择编辑<br/>①2.系统将当前现实的单据信息变为可编辑状态，并提供修改完成选项<br/>①3.总经理修改其中的一项或多项，完成后选择“修改完成”<br/>①4.系统保存并覆盖原草稿，跳转回3<br/><br/>②通过：<br/>②1.总经理选择通过<br/>②2.系统将该单据标记位生效并入账 ，记录本次操作至系统操作日志<br/><br/>③驳回：<br/>③1.总经理选择驳回 <br/>③2.系统将该单据标记位驳回状态，向制定的操作员发送消息，并记录本次操作至操作日志<br/> |
| 扩展流程 | 无                                        |
| 特殊需求 | 总经理可以批量审批                                |
----------------------
