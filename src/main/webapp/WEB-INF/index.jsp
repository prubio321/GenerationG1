<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.css"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Paulino Rubio</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


    <script>

        function llenarTablaAutos(listaAutos){
            var t=$('#tablaAutos').DataTable();
            console.log(listaAutos);
            $.each(listaAutos, function( index, auto ) {
                console.log( index + ": " + JSON.stringify(auto) );
                t.row.add([index+1, auto.id, auto.marca, auto.modelo, auto.color,auto.velocidad,
                    `<button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
                    <button onclick="editarAuto(`+auto.id+`)" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></button>
                    <button onclick="eliminarAuto(`+auto.id+`)" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></button>`
                ]).draw(false);
            });
        }

        function  respuestaCrearAuto(auto){
            console.log(auto)
            location.reload();

        }

        function  crearAuto(){
            var auto = {
                id:0,
                marca:'prueba',
                modelo:'prueba modelo',
                color: 'prueba color',
                velocidad: 200
            }
            $.post('http://localhost:8080/api/crear/autos',auto,(auto)=>respuestaCrearAuto(auto),'json');
        }

        function  editarAuto(id){
           /* var auto = {
                id:3,
                marca:'Ford',
                modelo:'Ranger',
                color: 'gris',
                velocidad: 209
            }
            $.post('http://localhost:8080/api/editar/autos',auto,(auto)=>respuestaCrearAuto(auto),'json');*/
            window.location.href = 'http://localhost:8080/auto/editarAutoAjax?id='+id
        }
        function  eliminarAuto(id){

            $.post('http://localhost:8080/api/eliminarById/autos',{id:id},(id)=>{
                location.reload();
            },'json');

        }

        $(document).ready( function () {
            var data = $("form").serialize();
            $.get('http://localhost:8080/api/obtener/autos', (listaAutos)=>llenarTablaAutos(listaAutos) , 'json');
        } );
    </script>
    <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
</head>
<body>

<table id="tablaAutos" class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Color</th>
        <th>Velocidad</th>
        <th>Acciones</th>
    </tr>
    </thead>

</table>

</body>
</html>
