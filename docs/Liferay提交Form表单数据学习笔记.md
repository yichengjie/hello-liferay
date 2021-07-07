1. 创建mvc类型的portlet
2. view.jsp页面中添加表单元素
    ```text
    <%--注意form 的 method为post，action与portlet:actionURL的var值对应--%>
    <portlet:actionURL var = "loginURL" name = "loginAction" />
    <p>
        <b>登录表单提交</b><br/>
        <form action ="${loginURL}" method ="post">
            用户名：<input type ="text" name ="<portlet:namespace/>username" /><br/>
            密码：<input type = "password" name ="<portlet:namespace/>password" /><br/>
            <input type ="submit" value ="提交" />
        </form>
    </p>
    ```
3. 编写后台业务处理逻辑
    ```java
    public class HelloMvcPortlet extends MVCPortlet {
        private Logger logger = LoggerFactory.getLogger(HelloMvcPortlet.class);
        /**
        * 登录业务处理
        * 注意@ProcessAction中的name要与portlet:actionURL中的name对应
        * @param actionRequest
        * @param actionResponse
        * @throws IOException
        * @throws PortletException
        */
        @ProcessAction(name = "loginAction")
        public void loginAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
            String username = ParamUtil.getString(actionRequest, "username") ;
            String password = ParamUtil.getString(actionRequest, "password") ;
            logger.info("username : {}", username);
            logger.info("password : {}", password);
        }
    }
    ```
4. 测试结果
    ```text
    2021-07-07 03:12:28.258 INFO  username : test@liferay.com
    2021-07-07 03:12:28.258 INFO  password : test
    ```
