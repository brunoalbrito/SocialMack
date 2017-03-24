<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../template/header_post_login.jsp"/>

<div class="row">

    <c:forEach items="${palestras}" var="palestra">

        <div class="col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Palestra X
                </div>
                <div class="panel-body">             
                    Dados da palestra
                </div>
            </div>
        </div>

    </c:forEach>

</div>

<c:import url="../template/footer_post_login.jsp"/>