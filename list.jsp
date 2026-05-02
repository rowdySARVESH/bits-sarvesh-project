<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>STRENGTH REGISTRY // MISSION CONTROL</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="dashboard-container">
    <h2>Performance Records</h2>
    <a href="/new" class="btn">LOG NEW LIFT</a>
    <table>
        <thead>
            <tr>
                <th>Record ID</th>
                <th>Athlete Name</th>
                <th>Class</th>
                <th>Lift Type</th>
                <th>Weight (KG)</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${records}" var="record">
                <tr>
                    <td>SYS-${record.recordId}</td>
                    <td style="font-weight: bold; color: #fff;">${record.athlete.name}</td>
                    <td>[${record.athlete.weightClass}]</td>
                    <td>${record.liftType}</td>
                    <td style="color: #3fb950;">${record.weightKgs} kg</td>
                    <td>${record.performanceDate}</td>
                    <td><a href="/edit/${record.recordId}" class="btn btn-edit">EDIT</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
