1. 创建mvc类型的portlet
2. 下载jquery3.6.0.js并放入src/main/resources/META-INF/resources/js目录中
3. 在init.jsp中添加jquery引用
    ```text
    <%
        String contextPath = request.getContextPath();
    %>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery3.6.0.js" />
    ```
4. view.jsp页面中添加页面元素
    ```text
    <button type="button" id="testBtn">测试Ajax</button><br>
    <div id="div1"></div>
    ```
5.  view.jsp中添加后台请求resourceURL标签，可写在div下面，注意这里的var与下面ajax请求的地址对应，id与后台resourceID对应
    ```text
    <portlet:resourceURL var="ajaxUrl" id="addOper" />
    ```
6. 编写js业务处理
    ```javascript
    <script type="text/javascript">
        $(function (){
            $("#testBtn").click(function(){
                doAjax() ;
            });
        }) ;
        function doAjax (){
            $.ajax({
                url: '${ajaxUrl}', // 注意这里与步骤5中resourceURL的var对应
                method: "POST",
                data:{
                    <portlet:namespace/>username: "yicj",
                    <portlet:namespace/>password: "123"
                },
                success:function(result){
                    $("#div1").html(result);
                }
            });
        }
    </script>
    ```
7. 编写后台处理逻辑
    ```java
    public class HelloMvcPorletPortlet extends MVCPortlet {
        // 这里需要按自己需要引入log4j依赖即可
        private Logger logger = LoggerFactory.getLogger(HelloMvcPorletPortlet.class);
        @Override
        public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
            throws IOException, PortletException {
            // 可以根据这个id作为不同请求的判断（增\删\改\查）
            String resourceID = resourceRequest.getResourceID();
            String username = ParamUtil.getString(resourceRequest, "username");
            String password = ParamUtil.getString(resourceRequest, "password") ;
            logger.info("resourceID : {}", resourceID);
            logger.info("username : {}", username);
            logger.info("password : {}", password);
            resourceResponse.setContentType("text/html");
            resourceResponse.getWriter().write("Resource served successfully!");
        }
    }
    ```
8. 测试结果
    ```text
    2021-07-06 07:42:44.271 INFO  [http-nio-8080-exec-8][HelloMvcPorletPortlet:45] resourceID : addOper
    2021-07-06 07:42:44.271 INFO  [http-nio-8080-exec-8][HelloMvcPorletPortlet:46] username : yicj
    2021-07-06 07:42:44.272 INFO  [http-nio-8080-exec-8][HelloMvcPorletPortlet:47] password : 123
    ```