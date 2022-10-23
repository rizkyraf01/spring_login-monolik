$(document).ready(function() {
    var table = $('#tablekaryawan').DataTable({
        searchPanes: true
    });
    table.searchPanes.container().prependTo(table.table().container());
    table.searchPanes.resizePanes();
});

console.log("Halo Aku Merin");