$( function() {
  $('#dialogAddTask' ).dialog({
    autoOpen : false,
  });
  $('#btnAddTask').click( function() {
    $('#dialogAddTask').dialog('open');
    return false;
  });
});
