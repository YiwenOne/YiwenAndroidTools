package com.example.yyiwen.fastmaildemo.Bean;

import java.util.List;

/**
 * Created by y.yiwen on 3/29/2017.
 */
public class LoginInfo {
    /**
     * success : true
     * User : {"UserID":"f248611c-cb39-4806-919e-71dac085d209","UserName":"test","Password":"123456","RealName":"李先生","NickName":"综合","MobilePhone":"17721022522","IDCard":null,"Email":null,"IsOnJob":false,"IsAdmin":false,"CompanyID":"c04b3ae6-1866-4490-9d73-fab0db121f12","CompanyName":"某车公司(测试数据)","DepartmentID":"3ac04261-8181-4255-9673-309d83badc86","DepartmentName":"销售人员(测试数据)","PositionID":"e155049d-9dcc-46cb-9a82-a9c9de096287","PositionName":"销售员1（测试数据）","MangerID":"1227fc37-8e05-43ed-be86-0ce5a401fd6f"}
     * Name : null
     * Pwd : null
     * Frm :
     * Role : [{"RoleID":"a7a247b1-3bd4-4c97-a7f9-92d7437fa0ef","RoleName":"销售顾问"}]
     * Module : [{"ModuleID":"688f8848-c0ba-4b34-b2f9-00d004abb6aa","ModuleName":"订单客户详情","NavigateUrl":"CustomerDetailforOrder","isMenu":false},{"ModuleID":"abcb99db-aae2-4384-8f1b-14c7b2936740","ModuleName":"战败审批","NavigateUrl":"DefeatApprove","isMenu":true},{"ModuleID":"50166dec-cdcf-4d4b-938c-0fb80349c0d7","ModuleName":"订单战败详情","NavigateUrl":"OrderDefeatInfo","isMenu":false},{"ModuleID":"cf8bd105-0185-4685-bbf0-09177e594ddb","ModuleName":"成交订单","NavigateUrl":"DealOrder","isMenu":true},{"ModuleID":"29300fec-ecbb-4841-a961-9064681b5f46","ModuleName":"StockView","NavigateUrl":"StockView","isMenu":true},{"ModuleID":"a7964a11-f299-4cba-9170-df2920030a11","ModuleName":"客户战败详情","NavigateUrl":"CustomerDefeatInfo","isMenu":false},{"ModuleID":"417ef14b-57df-4936-b78e-a62360222345","ModuleName":"保有客户详情","NavigateUrl":"CustomerDetailforTenure","isMenu":false},{"ModuleID":"be99eb9f-8b94-45a8-b5bd-10c5cadd21a3","ModuleName":"客户管理","NavigateUrl":"CustomerManage","isMenu":true},{"ModuleID":"8e5f3378-cdb0-4281-a0c5-01ae0a63463b","ModuleName":"经理端通知","NavigateUrl":"NoticeManager","isMenu":true},{"ModuleID":"6618d751-0570-42fd-b586-0c18952552a5","ModuleName":"通知公告详情","NavigateUrl":"NoticeInfo","isMenu":false},{"ModuleID":"fb7c3b8b-3f39-43e2-b0ab-36a9ffcf1ac4","ModuleName":"销售信息","NavigateUrl":"saleDetailInfo","isMenu":false},{"ModuleID":"dc7c3b8b-3f39-43e2-b0ab-36a9ffcf1ac4","ModuleName":"客户信息","NavigateUrl":"showCustomerInfo","isMenu":false},{"ModuleID":"da7c3b8b-3f39-43e2-b0ab-36a9ffcf1ac4","ModuleName":"试驾申请审核","NavigateUrl":"testDriveApprove","isMenu":true},{"ModuleID":"fa7c3b8b-3f39-43e2-b0ab-36a9ffcf1ac4","ModuleName":"已发送接待任务","NavigateUrl":"EnterRecorded","isMenu":true},{"ModuleID":"225b2245-ff18-45b7-8308-9b0b6b1023c4","ModuleName":"顾客详细信息","NavigateUrl":"CustomerDetailInfo","isMenu":false},{"ModuleID":"a7a247b1-3bd4-4c97-a7f9-92d7437fa0ef","ModuleName":"welcome","NavigateUrl":"welcome","isMenu":true},{"ModuleID":"fb7c3b8b-3f39-43e2-b0ab-36a9ffcf1ac8","ModuleName":"Notice","NavigateUrl":"Notice","isMenu":true},{"ModuleID":"ab8b96ec-d22c-46e2-8a9c-0b4b127ee9e2","ModuleName":"sysAdmin","NavigateUrl":"sysAdmin","isMenu":true},{"ModuleID":"e057bde2-a70a-42c6-a316-6766d17b795b","ModuleName":"录入车型","NavigateUrl":"NewCarBasic","isMenu":true},{"ModuleID":"aa5b9b89-8ec3-4c0b-bdbc-a79d2681b446","ModuleName":"DMSImport","NavigateUrl":"DMSImport","isMenu":true},{"ModuleID":"6bd6a4e8-403c-473f-9075-ef5f0a818788","ModuleName":"sysManage","NavigateUrl":"sysManage","isMenu":true},{"ModuleID":"a73abcdb-b8b4-46aa-9cfc-c6c891a5f6cc","ModuleName":"customerList","NavigateUrl":"customerList","isMenu":true},{"ModuleID":"fecee6f7-549b-4d40-a8ec-d621a788c3fc","ModuleName":"sysUserPermission","NavigateUrl":"sysUserPermission","isMenu":true},{"ModuleID":"6a3af326-a8b4-4873-b52b-c4d10595509a","ModuleName":"taskList","NavigateUrl":"taskList","isMenu":true},{"ModuleID":"f39701bf-e948-4789-8c14-28c6afd4a653","ModuleName":"taskInfo","NavigateUrl":"taskInfo","isMenu":true},{"ModuleID":"b3ca8895-002b-40a7-a3e0-90c085138532","ModuleName":"EnterRecord","NavigateUrl":"EnterRecord","isMenu":true},{"ModuleID":"452a3b57-d7e7-4d4a-bdc1-0cdbfc208e29","ModuleName":"taskReport","NavigateUrl":"taskReport","isMenu":true},{"ModuleID":"e23f28b2-98ad-4881-90d3-e9e7d44d3a63","ModuleName":"tracingList","NavigateUrl":"tracingList","isMenu":true},{"ModuleID":"ee37ac91-1b03-4c7f-aeaa-9b56f3c370aa","ModuleName":"经理端库存查看","NavigateUrl":"StockViewForManage","isMenu":true},{"ModuleID":"b45cb21b-aaa8-41d0-9475-0f7889122801","ModuleName":"通知接收(非经理端)","NavigateUrl":"NoticeAssistant","isMenu":true},{"ModuleID":"00000000-0000-0000-0000-000000000000","ModuleName":"欢迎","NavigateUrl":"welcome","isMenu":false}]
     * Permission : [{"PermissionID":"e155049d-9dcc-46cb-9a82-a9c9de096287","PermissionName":"编辑"},{"PermissionID":"cdece281-83c0-4a24-84c8-a176add92ab0","PermissionName":"编辑"},{"PermissionID":"a5c0e263-ef5c-4b7e-b325-1782223aeec5","PermissionName":"编辑"},{"PermissionID":"c0aae025-0e7d-4cd9-a9dd-e8cf819ebd50","PermissionName":"查看"},{"PermissionID":"e8f2e754-48cc-4201-807a-2b71af6ca57d","PermissionName":"编辑"},{"PermissionID":"39dd3770-e911-422b-ab4e-6f72e3c2ffcd","PermissionName":"编辑"},{"PermissionID":"a9b0ae01-17cc-4bae-9214-941d73f312c7","PermissionName":"编辑"},{"PermissionID":"81721c72-f8af-46de-a89c-ff6ed2e2d1b0","PermissionName":"编辑"},{"PermissionID":"2f4a9125-6214-4764-ac3d-ee0a4883aa0e","PermissionName":"编辑"},{"PermissionID":"70062291-2f38-4bfa-9499-2e2af6db6041","PermissionName":"编辑"},{"PermissionID":"6bd6a4e8-403c-473f-9075-ef5f0a818789","PermissionName":"查看"},{"PermissionID":"cdd6a4e8-403c-473f-9075-ef5f0a818789","PermissionName":"编辑"},{"PermissionID":"dfd6a4e8-403c-473f-9075-ef5f0a818789","PermissionName":"查看"},{"PermissionID":"fad6a4e8-403c-473f-9075-ef5f0a818789","PermissionName":"编辑"},{"PermissionID":"33b3700d-7c82-43d4-a84c-47d31463cbe6","PermissionName":"编辑"},{"PermissionID":"a7a247b1-3bd4-4c97-a7f9-92d7437fa0ef","PermissionName":"编辑"},{"PermissionID":"fb7c3b8b-3f39-43e2-b0ab-36a9ffcf1ac8","PermissionName":"查看"},{"PermissionID":"ab8b96ec-d22c-46e2-8a9c-0b4b127ee9e2","PermissionName":"查看"},{"PermissionID":"3fce528e-a1d0-4bdc-87cd-e89e63694ba5","PermissionName":"查看"},{"PermissionID":"aa5b9b89-8ec3-4c0b-bdbc-a79d2681b446","PermissionName":"查看"},{"PermissionID":"6bd6a4e8-403c-473f-9075-ef5f0a818788","PermissionName":"编辑"},{"PermissionID":"a73abcdb-b8b4-46aa-9cfc-c6c891a5f6cc","PermissionName":"查看"},{"PermissionID":"fecee6f7-549b-4d40-a8ec-d621a788c3fc","PermissionName":"编辑"},{"PermissionID":"6a3af326-a8b4-4873-b52b-c4d10595509a","PermissionName":"编辑"},{"PermissionID":"f39701bf-e948-4789-8c14-28c6afd4a653","PermissionName":"查看"},{"PermissionID":"b3ca8895-002b-40a7-a3e0-90c085138532","PermissionName":"查看"},{"PermissionID":"452a3b57-d7e7-4d4a-bdc1-0cdbfc208e29","PermissionName":"编辑"},{"PermissionID":"e23f28b2-98ad-4881-90d3-e9e7d44d3a63","PermissionName":"查看"},{"PermissionID":"b84f1222-a002-4e88-94ef-ed15ef7fa1e6","PermissionName":"编辑"},{"PermissionID":"bebac41e-9b07-42d2-9789-df5895f4d479","PermissionName":"编辑"}]
     */
    private String Token;

    public void setToken(String token) {
        this.Token = token;
    }

    public String getToken() {
        return Token;
    }

    private boolean success;
    /**
     * UserID : f248611c-cb39-4806-919e-71dac085d209
     * UserName : test
     * Password : 123456
     * RealName : 李先生
     * NickName : 综合
     * MobilePhone : 17721022522
     * IDCard : null
     * Email : null
     * IsOnJob : false
     * IsAdmin : false
     * CompanyID : c04b3ae6-1866-4490-9d73-fab0db121f12
     * CompanyName : 某车公司(测试数据)
     * DepartmentID : 3ac04261-8181-4255-9673-309d83badc86
     * DepartmentName : 销售人员(测试数据)
     * PositionID : e155049d-9dcc-46cb-9a82-a9c9de096287
     * PositionName : 销售员1（测试数据）
     * MangerID : 1227fc37-8e05-43ed-be86-0ce5a401fd6f
     */

    private UserEntity User;
    private Object Name;
    private Object Pwd;
    private String Frm;
    /**
     * RoleID : a7a247b1-3bd4-4c97-a7f9-92d7437fa0ef
     * RoleName : 销售顾问
     */

    private List<RoleEntity> Role;
    /**
     * ModuleID : 688f8848-c0ba-4b34-b2f9-00d004abb6aa
     * ModuleName : 订单客户详情
     * NavigateUrl : CustomerDetailforOrder
     * isMenu : false
     */

    private List<ModuleEntity> Module;
    /**
     * PermissionID : e155049d-9dcc-46cb-9a82-a9c9de096287
     * PermissionName : 编辑
     */

    private List<PermissionEntity> Permission;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUser(UserEntity User) {
        this.User = User;
    }

    public void setName(Object Name) {
        this.Name = Name;
    }

    public void setPwd(Object Pwd) {
        this.Pwd = Pwd;
    }

    public void setFrm(String Frm) {
        this.Frm = Frm;
    }

    public void setRole(List<RoleEntity> Role) {
        this.Role = Role;
    }

    public void setModule(List<ModuleEntity> Module) {
        this.Module = Module;
    }

    public void setPermission(List<PermissionEntity> Permission) {
        this.Permission = Permission;
    }

    public boolean isSuccess() {
        return success;
    }

    public UserEntity getUser() {
        return User;
    }

    public Object getName() {
        return Name;
    }

    public Object getPwd() {
        return Pwd;
    }

    public String getFrm() {
        return Frm;
    }

    public List<RoleEntity> getRole() {
        return Role;
    }

    public List<ModuleEntity> getModule() {
        return Module;
    }

    public List<PermissionEntity> getPermission() {
        return Permission;
    }

    public static class UserEntity {
        private String UserID;
        private String UserName;
        private String Password;
        private String RealName;
        private String NickName;
        private String MobilePhone;
        private Object IDCard;
        private Object Email;
        private boolean IsOnJob;
        private boolean IsAdmin;
        private String CompanyID;
        private String CompanyName;
        private String DepartmentID;
        private String DepartmentName;
        private String PositionID;
        private String PositionName;
        private String MangerID;

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public void setRealName(String RealName) {
            this.RealName = RealName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public void setMobilePhone(String MobilePhone) {
            this.MobilePhone = MobilePhone;
        }

        public void setIDCard(Object IDCard) {
            this.IDCard = IDCard;
        }

        public void setEmail(Object Email) {
            this.Email = Email;
        }

        public void setIsOnJob(boolean IsOnJob) {
            this.IsOnJob = IsOnJob;
        }

        public void setIsAdmin(boolean IsAdmin) {
            this.IsAdmin = IsAdmin;
        }

        public void setCompanyID(String CompanyID) {
            this.CompanyID = CompanyID;
        }

        public void setCompanyName(String CompanyName) {
            this.CompanyName = CompanyName;
        }

        public void setDepartmentID(String DepartmentID) {
            this.DepartmentID = DepartmentID;
        }

        public void setDepartmentName(String DepartmentName) {
            this.DepartmentName = DepartmentName;
        }

        public void setPositionID(String PositionID) {
            this.PositionID = PositionID;
        }

        public void setPositionName(String PositionName) {
            this.PositionName = PositionName;
        }

        public void setMangerID(String MangerID) {
            this.MangerID = MangerID;
        }

        public String getUserID() {
            return UserID;
        }

        public String getUserName() {
            return UserName;
        }

        public String getPassword() {
            return Password;
        }

        public String getRealName() {
            return RealName;
        }

        public String getNickName() {
            return NickName;
        }

        public String getMobilePhone() {
            return MobilePhone;
        }

        public Object getIDCard() {
            return IDCard;
        }

        public Object getEmail() {
            return Email;
        }

        public boolean isIsOnJob() {
            return IsOnJob;
        }

        public boolean isIsAdmin() {
            return IsAdmin;
        }

        public String getCompanyID() {
            return CompanyID;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public String getDepartmentID() {
            return DepartmentID;
        }

        public String getDepartmentName() {
            return DepartmentName;
        }

        public String getPositionID() {
            return PositionID;
        }

        public String getPositionName() {
            return PositionName;
        }

        public String getMangerID() {
            return MangerID;
        }
    }

    public static class RoleEntity {
        private String RoleID;
        private String RoleName;

        public void setRoleID(String RoleID) {
            this.RoleID = RoleID;
        }

        public void setRoleName(String RoleName) {
            this.RoleName = RoleName;
        }

        public String getRoleID() {
            return RoleID;
        }

        public String getRoleName() {
            return RoleName;
        }
    }

    public static class ModuleEntity {
        private String ModuleID;
        private String ModuleName;
        private String NavigateUrl;
        private boolean isMenu;

        public void setModuleID(String ModuleID) {
            this.ModuleID = ModuleID;
        }

        public void setModuleName(String ModuleName) {
            this.ModuleName = ModuleName;
        }

        public void setNavigateUrl(String NavigateUrl) {
            this.NavigateUrl = NavigateUrl;
        }

        public void setIsMenu(boolean isMenu) {
            this.isMenu = isMenu;
        }

        public String getModuleID() {
            return ModuleID;
        }

        public String getModuleName() {
            return ModuleName;
        }

        public String getNavigateUrl() {
            return NavigateUrl;
        }

        public boolean isIsMenu() {
            return isMenu;
        }
    }

    public static class PermissionEntity {
        private String PermissionID;
        private String PermissionName;

        public void setPermissionID(String PermissionID) {
            this.PermissionID = PermissionID;
        }

        public void setPermissionName(String PermissionName) {
            this.PermissionName = PermissionName;
        }

        public String getPermissionID() {
            return PermissionID;
        }

        public String getPermissionName() {
            return PermissionName;
        }
    }
}
