<%@ page language="java" %>
<html>
<head>
    <title>Student Result Form</title>

    <script>
        function validateForm() {
            let f = document.forms["form"];

            let roll = f["rollno"].value;
            let name = f["name"].value;

            let marks = [
                f["sub1"].value,
                f["sub2"].value,
                f["sub3"].value,
                f["sub4"].value,
                f["sub5"].value
            ];

            if (roll == "" || name == "") {
                alert("Roll No and Name required!");
                return false;
            }

            for (let i = 0; i < marks.length; i++) {
                if (marks[i] == "" || isNaN(marks[i]) || marks[i] < 0 || marks[i] > 100) {
                    alert("Enter valid marks (0–100) for all subjects!");
                    return false;
                }
            }

            return true;
        }
    </script>
</head>

<body>

<h2>Student Result Form</h2>

<form name="form" action="result" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="rollno"><br><br>
    Name: <input type="text" name="name"><br><br>

    Sub1: <input type="text" name="sub1"><br><br>
    Sub2: <input type="text" name="sub2"><br><br>
    Sub3: <input type="text" name="sub3"><br><br>
    Sub4: <input type="text" name="sub4"><br><br>
    Sub5: <input type="text" name="sub5"><br><br>

    <input type="submit" value="Calculate Result">
</form>

</body>
</html>