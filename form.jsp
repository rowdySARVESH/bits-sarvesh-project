<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>INPUT LOG // SYSTEM</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="dashboard-container">
    <h2>${empty liftRecord.recordId ? 'Initialize New Log' : 'Modify Existing Log'}</h2>

    <form:form action="/save" modelAttribute="liftRecord" method="POST">
        <form:hidden path="recordId"/>

        <div class="form-group">
            <label>Select Athlete:</label>
            <form:select path="athlete.athleteId">
                <form:option value="" label="-- SYSTEM OVERRIDE: SELECT ATHLETE --"/>
                <form:options items="${athletes}" itemValue="athleteId" itemLabel="name"/>
            </form:select>
            <form:errors path="athlete" cssClass="error"/>
        </div>

        <div class="form-group">
            <label>Lift Category:</label>
            <form:select path="liftType">
                <form:option value="Squat">Squat</form:option>
                <form:option value="Bench">Bench Press</form:option>
                <form:option value="Deadlift">Deadlift</form:option>
            </form:select>
        </div>

        <div class="form-group">
            <label>Mass Moved (KGs):</label>
            <form:input path="weightKgs" type="number" step="0.5"/>
            <form:errors path="weightKgs" cssClass="error"/>
        </div>

        <div class="form-group">
            <label>Date of Execution:</label>
            <form:input path="performanceDate" type="date"/>
            <form:errors path="performanceDate" cssClass="error"/>
        </div>

        <button type="submit" class="btn">EXECUTE_COMMIT</button>
        <a href="/" class="btn" style="background: #30363d; margin-left: 10px;">CANCEL</a>
    </form:form>
</div>
</body>
</html>
