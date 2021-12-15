// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
    "language": {
      "lengthMenu": "Mostrando _MENU_ registros por página",
      "zeroRecords": "No se encontraron registros :(",
      "info": "Mostrando la página: _PAGE_ de: _PAGES_",
      "infoEmpty": "No se encontraron registros :(",
      "infoFiltered": "(filtrado de _MAX_ registros totales)",
      "paginate": {
        "previous": "Página anterior",
        "next": "Página siguiente"
      }
    }
  });
});
