<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Pie Chart</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>
<body>
  <canvas id="myChart"></canvas>
  <script type="text/javascript">
    var ctx = document.getElementById("myChart").getContext("2d");

    // Replace these with your actual data
    var barColors = ["#FF6384", "#36A2EB", "#FFCE56", "#FFCC99", "#808080", "#F0E68C"];
   
    var myChart = new Chart(ctx, {
      type: "pie",
      data: {
        labels: ["2018", "2019", "2020", "2021", "2022", "2023"],
        datasets: [{
          backgroundColor: barColors,
          data: [${requestScope.year18},${requestScope.year19},${requestScope.year20},${requestScope.year21},${requestScope.year22},${requestScope.year23}]
        }]
      },
      options: {
        responsive: true
      }
    });
  </script>
</body>
</html>
