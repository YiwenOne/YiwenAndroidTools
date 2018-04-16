package com.example.yyiwen.fastmaildemo.Utils;

/**
 * Created by w.pitt on 2016/1/27.
 */
public class UrlUtils {
//    public static final String ImageIP = "http://imm.cjatech.com/";
    public static final String ImageIP = "http://crm.cjatech.com/";
//    public static final String ImageIP = "http://crm3.cjatech.com/";
    //    public static final String Crm3IP = "http://crm3.cjatech.com/";

    /*更新地址*/
    public static final String downloadUrl = ImageIP + "CJCRM.apk";
//    public static final String downloadUrl = ImageIP + "imManagement.apk";
    /*基地址*/
//    public static final String BASEIP = "http://imm.cjatech.com/api/CommonApi?API=";
    public static final String BASEIP = ImageIP + "api/CommonApi?API=";
    /*peter基地址*/
//    public static final String BASEIPPERRER = "http://imm.cjatech.com/api/common?API=";
    public static final String BASEIPPERRER = ImageIP + "api/common?API=";

    /*经理端  管理界面报表接口*/
    public static final String MAG_FORM_Url = BASEIP;
    /*新增库存查看时间*/
    public static final String INSERT_CHECK_TIME = BASEIPPERRER + "InsertViewStock";
    /*我的信息*/
    public static final String GET_MYINFO = BASEIP + "GetMySelfInfo";
    /*登录*/
    public static final String Login = ImageIP + "api/Login?";
    /*销售额和排名*/
    public static final String GETPERFORMANCE = BASEIP + "GetPerformance";
    /*是否有新的接待*/
    public static final String ISHAVERECEPTION = BASEIP + "IsHaveReception";
    /*潜客数量*/
    public static final String GETHIDDENCOUNT = BASEIP + "GetHiddenPassengerCount";
    /*订单客户数量*/
    public static final String GETORDPASCOUNT = BASEIP + "GetOrderPassengerCount";
    /*保有客户数量*/
    public static final String GETRETAINCOUNT = BASEIP + "GetRetainPassengerCount";
    /*未读消息*/
    public static final String GETMYMESSAGECOUNT = BASEIP + "GetMyMessageCount";
    /*贷款*/
    public static final String GETLOANRECINFO = BASEIP + "GetLoanRecordListByFlowID";
    /*保险*/
    public static final String GETINSRECINFO = BASEIP + "GetInsuranceRecordListByFlowID";
    /*订单详情*/
    public static final String GETORDERDETAILINFO = BASEIP + "GetOrderInfoByCustomerID";
    /*订单申请战败*/
    public static final String DEFAPPFORORDER = BASEIP + "InsertDefeatApproveForOrder";
    /*订单成交确认*/
    public static final String SUREORDERDEAL = BASEIP + "UpdateCustomerInfoForBecomeCompleted";
    /*确定是否跟进*/
    public static final String REQISSTRENFOLLOW = BASEIP + "UpdateCustomerInfoByImportance";
    /*修改等级*/
    public static final String CHANGELEVEL = BASEIP + "UpdateCustomerInfoByCustomerLevel";
    /*潜客列表*/
    public static final String GETHIDDENLISt = BASEIP + "GetHiddenPassengerList";
    /*跟进记录*/
    public static final String ADDFOLLOWDATA = BASEIP + "InsertTaskRecordDetail";
    /*以往资料*/
    public static final String GETBEFRECORDDETAIL = BASEIP + "GetTaskRecordDetailListByCustomerIDForEnter";
    /*客户申请战败*/
    public static final String DEFAPRFORCUSTOME = BASEIP + "InsertDefeatApproveForCustomer";
    /*电话邀约*/
    public static final String INSERTOFFERBYPHONE = BASEIP + "InsertOfferByPhone";
    /*订单列表*/
    public static final String GETORDERINFO = BASEIP + "GetOrderPassengerInfo";
    /*全款提车  保有客户*/
    public static final String GETRETAINPASLIST = BASEIP + "GetRetainPassengerList";
    /*保险记录 BY cusID*/
    public static final String GETINSRECORDCUSTOMER = BASEIP + "GetInsuranceRecordListByCustomerID";
    /*跟进详情*/
    public static final String GETRECORDDETAILLSIT = BASEIP + "GetTaskRecordDetailListByCustomerID";
    /*判断客户申请试驾状态*/
    public static final String GET_TRY_DRIVE_STATE = BASEIP + "GetTestDriveStateByFlowID";
    /*贷款记录  BY cusID*/
    public static final String GETLOANRECINFOBYCUS = BASEIP + "GetLoanRecordListByCustomerID";
    /*经理端Home*/
    public static final String MANAGERINDEXPETER = BASEIPPERRER + "ManagerIndexPeter";
    /*潜客搜索*/
    public static final String GETSAlESPASLIST = BASEIP + "GetSalesPassengerList";
    /*客户详情*/
    public static final String GETCLIENTInfo = BASEIP + "GetCustomerInfoForDetail";
    /*今日待完善任务列表*/
    public static final String STAND_COMPLETE_TASK = BASEIP + "GetReceivePassengerListByNotComplete";
    /*今日已完成的任务列表*/
    public static final String END_TASK = BASEIP + "GetReceivePassengerListByComplete";
    /*销售员的跟进任务列表*/
    public static final String FOLLOW_TASK = BASEIP + "GetTaskRecordListForSale";
    /*是否有试驾界面*/
    public static final String TRY_DRIVE_SHOW = BASEIP + "GetTestDriveByNext";
    /*销售端  客户详情界面试驾信息*/
    public static final String TRY_DRIVE_Info = BASEIP + "GetTestDriveByCustomerID";
    /*设置为客流*/
    public static final String SET_TO_RUN_OF_CLIENT = BASEIP + "SetPassengerFlowIsProfile";
    /*申请试驾*/
    public static final String APPLY_TRY_DRIVE = BASEIP + "InsertTestDriveForApproveAndCar";
    /*获取下拉框数据*/
    public static final String GET_SPINNER = BASEIP + "GetCRModelByName";
    /*.获取客户资料*/
    public static final String GET_CLIENT_INFO = BASEIP + "GetCustomerInfoForDetail";
    /*.提交客户资料*/
    public static final String COMMIT_CLIENT_INFO = BASEIP + "InsertCustomerInfoForDetail";
    /*.根据是否有试驾判断是否更新试驾内容*/
    public static final String UPDATE_TRY_DRIVE_DETAIL = BASEIP + "UpdateTestDriveByFirst";
    /*.客户战败列表*/
    public static final String GET_CLIENT_LOSE = BASEIP + "GetCustomerInfoForCustomerDefeat";
    /*.订单战败列表*/
    public static final String GET_ORDER_LOSE = BASEIP + "GetCustomerInfoForOrderDefeat";
    //全款提车
    public static final String FullPayment = BASEIPPERRER + "FullPaymentPeter";
    /*投诉删除*/
    public static final String ComplaintDelPeter = BASEIPPERRER + "ComplaintDelPeter";
    /*投诉列表*/
    public static final String ComplainPeter = BASEIPPERRER + "ComplainPeter";
    /*.销售端 待跟进客户*/
    public static final String GET_TASK_RECORD_BY_SALESID = BASEIP + "GetTaskRecordBySalesID";
    /*.销售端 跟进记录*/
    public static final String GET_TASK_RECORD_DETAILS_FOR_SALESID = BASEIP + "GetTaskRecordDetailForSalesID";
    /*.销售端 移除客户*/
    public static final String DELETE_tASK_RECORD = BASEIP + "DeleteTaskRecordForTaskRecordID";
    /*.销售端 通知公告列表*/
    public static final String GET_SALES_NOTICE = BASEIP + "GetMyMessageList";
    /*.查询车型库存列表*/
    public static final String GET_NUM_BY_STOCK = BASEIP + "GetNumByStockForCondition";
    /*.查询重点库存列表*/
    public static final String GET_FOCALCAR_STOCKLIST = BASEIP + "GetFocalCarStockListByCompanyID";
    /*.销售端 客户战败列表*/
    public static final String GET_SALES_CLIENT_LOSE = BASEIP + "GetCustomerInfoForCustomerDefeat";
    /*.销售端 订单战败列表*/
    public static final String GET_SALES_ORDER_LOSE = BASEIP + "GetCustomerInfoForOrderDefeat";
    /*.经理端 管理界面数据*/
    public static final String GET_MAG_MANAGE = BASEIPPERRER + "ManageIndexPeter";
    /*经理端管理全部潜客数量*/
    public static final String GET_MAG_HIDDEN_COUNT = BASEIPPERRER + "ManageIndexPeter";
    /*经理端管理全部保客数量*/
    public static final String GET_MAG_RETAIN_COUNT = BASEIPPERRER + "ManageIndexPeter";
    /*.经理端 客户战败列表*/
    public static final String GET_MAG_CLIENT_LOSE = BASEIPPERRER + "DefeatListPeter";
    /*.经理端 订单战败列表*/
    public static final String GET_MAG_ORDER_LOSE = BASEIPPERRER + "DefeatListPeter";
    /*.经理端 客户战败详情*/
    public static final String GET_MAG_CLIENT_LOSE_DETAIL = BASEIPPERRER + "DefeatInfoPeter";
    /*.经理端 订单确认战败详情*/
    public static final String GET_MAG_ORDER_LOSE_DETAIL = BASEIPPERRER + "DefeatInfoPeter";
    /*.经理端 确认请求战败*/
    public static final String AGREE_ORDER = BASEIPPERRER + "SureDefeatPeter";
    /*.经理端 驳回请求销售员列表*/
    public static final String GET_MAG_REJECT_SALES = BASEIPPERRER + "CancelUserListPeter";
    /*.经理端 确认驳回请求成功*/
    public static final String GET_MAG_SURE_CANCEL_DEFEAT = BASEIPPERRER + "CancelDefeatPeter";
    /*.经理端 通告列表*/
    public static final String MAG_NOTICE_FORM = BASEIPPERRER + "MessagePeter";
    /*.经理端 发送通告*/
    public static final String MAG_SEND_NOTICE = BASEIPPERRER + "MessageSendPeter";
    /*.经理端 通告详情 销售员列表*/
    public static final String MAG_NOTICE_DETAIL_SALES = BASEIPPERRER + "MessageUserPeter";
    /*客户离店   客流*/
    public static final String PASSAGEFLOWEXIT = BASEIP + "PassengerFlowExit";
    /*销售端 通知详情*/
    public static final String SALES_NOTICE_DETAIL = BASEIPPERRER + "MessageDetailPeter";
    /*查询他人客户*/
    public static final String GetOtherPassengerList = BASEIP + "GetOtherPassengerList";
    /*查询自己*/
    public static final String GetMySelfPassengerList = BASEIP + "GetMySelfPassengerList";
    /*确定关联*/
    public static final String RelatePassengerFlow = BASEIP + "RelatePassengerFlow";
    /*新的接待*/
    public static final String GetCurrentPassengerInfo = BASEIP + "GetCurrentPassengerInfo";
    /*有效/无效客户*/
    public static final String ValidPassengerFlow = BASEIP + "ValidPassengerFlow";
    /*经理端订单跟进*/
    public static final String OrderDealPeter = BASEIPPERRER + "OrderDealPeter";
    /*保险用户历史*/
    public static final String GetInsuranceRecordForUserHistory = BASEIP + "GetInsuranceRecordForUserHistory";
    /*保存客户试驾信息*/
    public static final String SUBMIT_CLEINT_TRY_DRIVE_INFO = BASEIP + "UpdateTestDriveByFirst";
    /*获取贷款历史记录*/
    public static final String GET_LOAN_HISTORY = BASEIP + "GetLoanRecordForUserHistory";
    /*获取贷款历史记录详情*/
    public static final String GET_LOAN_HISTORY_DETAILS = BASEIP + "GetLoanRecordListByCustomerID";
    /*获取所有销售员*/
    public static final String GET_ALL_USER = BASEIP + "MessageAllUserPeter";
    /*订单详情*/
    public static final String OrderDetailPeter = BASEIPPERRER + "OrderDetailPeter";
    /*全款提车详情*/
    public static final String FullPaymentDetailPeter = BASEIPPERRER + "FullPaymentDetailPeter";
    /*公司 车的类型*/
    public static final String GetCarModelByCompanyID = BASEIP + "GetCarModelByCompanyID";
    /*全部潜客*/
    public static final String PossibleCustomerPeter = BASEIPPERRER + "PossibleCustomerPeter";
    /*销售员列表*/
    public static final String CustomerInfoChangePeter = BASEIPPERRER + "CustomerInfoChangePeter";
    /*经理  所有保客*/
    public static final String HasCustomerPeter = BASEIPPERRER + "HasCustomerPeter";
    /*上传头像*/
    public static final String UPLOAD_HEADIAMGE = ImageIP + "api/Sales/SalesApi/UpLoadAvatar?SalesID=";
    /*上传二维码*/
    public static final String UPLOAD_RECODE = ImageIP + "api/Sales/SalesApi/UpdateQRcode?SalesID=";
    /*汽车车型*/
    public static final String GET_CAR_TYPE = BASEIP + "GetCarModelByCompanyID";
    /*汽车颜色*/
    public static final String GET_CAR_COLOR = BASEIP + "GetCarColorByCompanyID";
    /*汽车配置*/
    public static final String GET_CAR_CONFIGURE = BASEIP + "GetCarConfigurationByCompanyID";
    /*销售员详情*/
    public static final String GET_SALES_DETAILS = BASEIPPERRER + "SalesInfoPeter";
    /*判断现场或者跟进成交*/
    public static final String GET_TURN_OR_FOLLOW = BASEIP + "GetOrderInfoForIsTaskRecord";
    /*提交(现场或者跟进)成交信息*/
    public static final String SUBMIT_TURNOVER_INFO = BASEIP + "InsertOrderInfoByOver";
    /*提交订单信息*/
    public static final String SUBMIT_ORDER_TURNOVER_INFO = BASEIP + "InsertOrderInfoByFirst";
    /*提交客户意见*/
    public static final String SUBMIT_FEEDBACK = BASEIP + "InsertSuggestRecord";
    /*获取库存数目*/
    public static final String GET_CAR_STOCK_NUM = BASEIP + "GetNumByStockForCondition";
    /*获取重点库存*/
    public static final String GET_KEY_STOCK = BASEIP + "GetFocalCarStockListByCompanyID";
    /*经理端  删除客户*/
    public static final String CustomerInfoDelPeter = BASEIPPERRER + "CustomerInfoDelPeter";
    /*经理端  客户转移*/
    public static final String CustomerInfoTransferPeter = BASEIPPERRER + "CustomerInfoTransferPeter";
    /*新增贷款记录*/
    public static final String INSERT_LOAN_RECORD = BASEIP + "InsertLoadRecord";
    /*上传录音*/
    public static final String updateluyin = ImageIP + "api/Sales/SalesApi/UpdateSoundRecord";
    /*销售端 通告点击请求确认是否已读*/
    public static final String SUBMIT_SALES_ISREAD = BASEIP + "SetMyMessageIsRead";
    /*经理端 通告点击请求确认是否已读*/
    public static final String SUBMIT_MAG_ISREAD = BASEIPPERRER + "MessageReadPeter";
    /*经理端 战败列表请求确认是否已读*/
    public static final String SUBMIT_Lose_ISREAD = BASEIPPERRER + "InfoReadPeter";
    /*经理端  潜在客户列表*/
    public static final String GET_POSSIBLE_CLIENT = BASEIPPERRER + "SalesInfoPossiblePeter";
    /*经理端  保有客户列表*/
    public static final String GET_HAS_CLIENT = BASEIPPERRER + "SalesInfoHasPeter";
    /*经理端  潜在客户列表*/
    public static final String GET_MAG_FOLLOW_CLIENT = BASEIPPERRER + "SalesInfoPeter";
    /*更新跟进记录的备注接口*/
    public static final String UpdateTaskRecordDetailForComment = BASEIP + "UpdateTaskRecordDetailForComment";
    /*更新邀约备注*/
    public static final String UpdateOfferForComment = BASEIP + "UpdateOfferForComment";
    /*以往资料*/
    public static final String GetAllTaskRecordDetailListByCustomerIDForEnter = BASEIP + "GetAllTaskRecordDetailListByCustomerIDForEnter";
    /*关联保险*/
    public static final String InsertInsuranceRecord = BASEIP + "InsertInsuranceRecord";
    /*经理端消息以读*/
    public static final String MessageReadPeter = BASEIP + "MessageReadPeter";
    /*客户资料提交 更新接口*/
    public static final String UPDATE_CLIENT_INFO = BASEIP + "UpdateCustomerInfoForDetail";
    /*试驾历史信息*/
    public static final String GET_TAY_HISTORY = BASEIP + "GetHistoryTestDrive";
    /*显示试驾历史界面*/
    public static final String TRY_DRIVE_HISTORY = BASEIP + "GetHistoryTestDrive";
    /*客户接待量*/
//    public static final String MAGCUSRECEPTION = BASEIPPERRER + "GetReceptionNumByEveryHourForManager";
    public static final String MAGCUSRECEPTION = BASEIPPERRER + "GetReceptionNumByEveryHour2";
    /*客户跟进量*/
//    public static final String MAGCUSFOLLOW = BASEIPPERRER + "GetTaskRecordNumByEveryHourForManager";
    public static final String MAGCUSFOLLOW = BASEIPPERRER + "GetTaskRecordNumByEveryHour2";
    /*展厅成交量*/
    public static final String MAGCOMPANYDEAL = BASEIPPERRER + "GetVolumeForManager";
    /*展厅战败数*/
    public static final String MAGCOMPANYDEF = BASEIPPERRER + "GetDeferNumForManager";
    /*播放录音接口*/
    public static final String SOUNDRECORD = ImageIP + "UpLoads/SoundRecord";
    /*销售端 客户接待量*/
    public static final String CUSRECEPTION = BASEIP + "GetReceptionNumByEveryHourForManager";
    /*销售端 客户跟进量*/
    public static final String CUSFOLLOW = BASEIP + "GetTaskRecordNumByEveryHourForManager";
    /*销售端 展厅成交量*/
    public static final String COMPANYDEAL = BASEIP + "GetVolumeForManager";
    /*销售端 展厅战败数*/
    public static final String COMPANYDEF = BASEIP + "GetDeferNumForManager";
    /*获取所有销售员*/
    public static final String salesInfoGet_Robin = BASEIP + "salesInfoGet_Robin";
    /*客户成交率*/
    public static final String MAGCUSDEAL = BASEIP + "GetNumForTurnoverRateByManager";
    /*展厅混合总客流*/
    public static final String MAGCUSHUNHE = BASEIP + "GetTotalFlowNumForManager";
    /*电话客流量*/
    public static final String MAGCUSFOLLNUM = BASEIP + "GetPhoneFlowNumForManager";
    /*网电销渠道客流量*/
    public static final String MAGNETWORK = BASEIP + "GetNetworkFlowNumForManager";
    /*首次客流量*/
    public static final String MAGFIRSTS = BASEIP + "GetFirstFlowNumForManager";
    /*潜客留档率   修改版  简豪提供*/
    public static final String GetPotentialCustomerNum = BASEIP + "GetPotentialCustomerNum";
    /*潜客留档率*/
    public static final String MAGCUSLIUDANG = BASEIP + "GetReceptionNumForManager";
    /*试乘试驾*/
    public static final String testDriveRateGetByMonthDate_Robin = BASEIP + "testDriveRateGetByMonthDate_Robin";
    /*经理端  保有客户*/
    public static final String GetTenureCustomer_Twory = BASEIP + "GetTenureCustomer_Twory";
    /*经理端  发送消息接口1*/
    public static final String MAG_SEND_MSG1 = BASEIPPERRER + "MessageSendMsgPeter";
    /*经理端  发送消息接口2*/
    public static final String MAG_SEND_MSG2 = BASEIPPERRER + "MessageSendUsersPeter";
    /*车型库存配置*/
    public static final String GET_CAR_CONFIGURE1 = BASEIPPERRER + "GetCarConfigList_Twory";
    /*车型库存颜色*/
    public static final String GET_CAR_COLOR1 = BASEIPPERRER + "GetCarColorList_Twory";
    /*内饰颜色*/
    public static final String GET_CAR_TRIM_COLOR = BASEIPPERRER + "GetCarInnerColorListBy_Robin";
    /*车型库存总数和车型数目*/
    public static final String GET_CARTYPE_TOTALNUM = BASEIPPERRER + "GetCarList_Twory";
    /*经理端搜索*/
    public static final String GetCustomerListByManagerIDOrCondition = BASEIP + "GetCustomerListByManagerIDOrCondition";
    /*判断是否  已经战败批准了*/
    public static final String GetDefeatByCustomerID_Android_Rob = BASEIP + "GetDefeatByCustomerID_Android_Rob";
    /*根据FlowID 获取相应的来店详情*/
    public static final String GetCustomerInfoForDetailByFlowID = BASEIP + "GetCustomerInfoForDetailByFlowID";
    /*填写订单车型接口*/
    public static final String GET_ORDER_CAR_TYPE = BASEIPPERRER + "GetCarModelZaikuByCompanyID_Android_Rob";
    /*填写订单配置接口*/
    public static final String GET_ORDER_CAR_CONFIGURE = BASEIPPERRER + "GetCarConfigZaikuByCarModelID_Android_Rob";
    /*填写订单颜色接口*/
    public static final String GET_ORDER_CAR_COLOR = BASEIPPERRER + "GetCarColorZaikuByCarConfigID_Android_Rob";
    /*修改密码接口*/
    public static final String CHANGE_PASSWORD = BASEIPPERRER + "UpdateUserPassword_Twory";
    /*获取版本号接口*/
    public static final String GET_VERSIONNUM = BASEIPPERRER + "GetVersionByClientType_Twory";
    /*推送*/
    public static final String PushUrl = ImageIP + "api/JPushApi";

    /*销售目标*/
    public static final String GET_SALE_TARGET = BASEIPPERRER + "SalesTargets";
    /*获取日数据*/
    public static final String GET_DAY_DATA = BASEIPPERRER + "saleHistoryDataByDay_Robin";
    /*获取月数据*/
    public static final String GET_MONTH_DATA = BASEIPPERRER + "saleHistoryDataByMonth_Robin";
    //    /*结束试乘试驾*/
//    public static final String END_TRY_DRIVE = BASEIP + "EndTestDrive";
    /*请求员工报表数据*/
    public static final String GET_MAG_SALE_FORM = BASEIPPERRER + "ManGetsalesTodayData_Robin";
    /*经理端设置销售员目标*/
    public static final String SET_SALE_TARGET = BASEIPPERRER + "salesTargetsSet_Robin";
    /*经理端获取销售员目标数据*/
    public static final String GET_MAG_SALE_TARGET = BASEIPPERRER + "getSaleInfoContainsTargetsBySaleID_Robin";
    /*销售端 提交试驾评价数据*/
    public static final String Insert_drive_appraise = BASEIP + "TestDriveCommentAdd";
    /*销售员获取销售员离开原因类别*/
    public static final String GET_LEAVE_REASON = BASEIPPERRER + "leaveConfigNameGetByUserID_Robin";
    /*销售员发送离开原因说明*/
    public static final String SEND_LEAVE_REASON = BASEIPPERRER + "leaveConfigReasonSetByUserID_Robin";
    /*销售员确认到岗*/
    public static final String SURE_BACK = BASEIPPERRER + "leaveConfigOnWorkSetByUserID_Robin";
    /*销售员状态*/
    public static final String GET_SALE_STATE = BASEIPPERRER + "saleStateGetByUserID_Robin";
    /*试驾信息接口*/
    public static final String GET_NEW_TRY_DRIAVE = BASEIPPERRER + "GetTestDriveCarsInfo";
    /*当前试驾状态接口*/
    public static final String GET_CURRENT_TRY_DRIAVE = BASEIP + "CurrentTestDriverState";
    /*结束试乘试驾*/
    public static final String END_DRIVE_STATE = BASEIPPERRER + "EndTestDrive_Robin";
    /*获取试驾信息接口*/
    public static final String GET_TRY_DRIAVE = BASEIPPERRER + "GetMyStateAndTestDriveCarInfo_Robin";
    /*获取试驾状态接口*/
    public static final String GET_TRY_DRIAVE_State = BASEIPPERRER + "TestDriveStateGetByFlowID_Robin";
    /*当前试驾历史记录*/
    public static final String GET_DRIVE_HISTORY = BASEIP + "TestDriveRecord";
    /*保存提醒设置*/
    public static final String workRemindConfigManagerSet_Robin = BASEIP + "workRemindConfigManagerSet_Robin";
    /*经理端获取全部提醒设置*/
    public static final String workRemindConfigManageGet_Robin = BASEIP + "workRemindConfigManageGet_Robin";
    /*销售端获取所有提醒设置*/
    public static final String workRemindConfigSaleGet_Robin = BASEIP + "workRemindConfigSaleGet_Robin";
    /*销售端设置提醒时间*/
    public static final String workRemindConfigSaleSet_Robin = BASEIP + "workRemindConfigSaleSet_Robin";
    /*获取全部的消息*/
    public static final String GetAllNewsTypes = BASEIP + "GetAllNewsTypes";
    /*消息的详细列表*/
    public static final String GetNewsTypesList = BASEIP + "GetNewsTypesList";
    /*行为分析*/
    public static final String GET_ACTION_ANALYSE = BASEIPPERRER + "GetsalesTimeAllocationBycomID_Robin";
    /*经理端批注浏览*/
    public static final String tracingCustomerCommentGetbyManID_robin = BASEIP + "tracingCustomerCommentGetbyManID_robin";
    /*消息已读*/
    public static final String NewsIsReadUpdateByUserID_Robin = BASEIP + "NewsIsReadUpdateByUserID_Robin";
    /*添加批注*/
    public static final String customerCommentAddByUserID_Robin = BASEIP + "customerCommentAddByUserID_Robin";
    /*群发 添加短信*/
    public static final String BatchSendMessage = BASEIP + "BatchSendMessage";
    /*发送通知 新增接口*/
    public static final String SendWorkAlert = BASEIP + "SendWorkAlert";
    /*首页未读信息数目*/
    public static final String NotReadNewsCount = BASEIP + "NotReadNewsCount";
    /*销售端 试乘试驾评价详情*/
    public static final String Try_drive_details = BASEIPPERRER + "GetTestDriveCommentByCustomerID";
    /*删除消息*/
    public static final String DeleteNewsByID = BASEIP + "DeleteNewsByID";
    /*新的配置接口*/
    public static final String new_configure = BASEIPPERRER + "GetCarConfigListBy_Robin";
    /*新的颜色接口*/
    public static final String new_color = BASEIPPERRER + "GetCarColorListBy_Robin";
    /*判断库存有无颜色*/
    public static final String NO_COLOR = BASEIP + "GetCarStockCount";
    /*无前台自己设置接待信息*/
    public static final String NoRecReceive = BASEIPPERRER + "EnterRecordInsertApp_Robin";
    /*更新销售员状态*/
    public static final String UpdateSalerState = BASEIPPERRER + "UserStateUpdate_Robin";
    /*判断有无前台*/
    public static final String YesOrNoRec = BASEIPPERRER + "GetCompanyConfigInfo_Twory";
    //    /*无前台自主同意试驾*/
//    public static String AgreeTryDrive = BASEIPPERRER + "testDriveApprove_Robin";
    /*无前台申请试驾*/
    public static final String noRec_Apply_try_drive = BASEIP + "InsertTestDriveForApproveBySales";
    //全款提车
    public static final String FullPaymentPeter = BASEIP + "FullPaymentPeter";
    /*经理端你搜索*/
    public static final String GetSearchCustome = BASEIP + "GetSearchCustome";
    /*经理端跟进管理界面*/
    public static final String GetSalesTodayFollowUp = BASEIP + "GetSalesTodayFollowUp";
    /*经理端跟进管理历史记录-天*/
    public static final String GetSalesTodayFollowUpHIS = BASEIP + "GetSalesTodayFollowUpHIS";
    /*经理端跟进管理历史记录-月*/
    public static final String GetSalesTodayFollowUpHISMonth = BASEIP + "GetSalesTodayFollowUpHISMonth";
}
