<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="recoveryrooms">
    <jsp:body>
        <h2>
            <c:if test="${recoveryRoom['new']}"> New </c:if> Recovery
        </h2>
        <form:form modelAttribute="recoveryRoom"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${recoveryRoom.id}"/>
            <div class="form-group has-feedback">
                <petclinic:inputField label="Room name" name="name"/>
                <petclinic:inputField label="Room size in m2" name="size"/>
                <petclinic:checkboxField label="Secure room?" name="secure"/>
                <div class="control-group">
                    <petclinic:selectField name="roomType" label="Room type " names="${types}" size="5"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit">Update Room</button>
                </div>
            </div>
        </form:form>
        <c:if test="${!recoveryRoom['new']}">
        </c:if>
    </jsp:body>
</petclinic:layout>
