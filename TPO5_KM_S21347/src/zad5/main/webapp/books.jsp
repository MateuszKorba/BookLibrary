<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books Library</title>
    <link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Enter the book genre you are looking for" autocomplete="off">
    <table id="myTable">
        <tr class="header">
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${books}" var="book">
        <tr class="child">
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>${book.price}</td>
        </tr>
        </c:forEach>
    </table>
    <script>
        function myFunction() {
            var input,filter,table,tr,td,i,txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[3];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    }
                    else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</body>
</html>
