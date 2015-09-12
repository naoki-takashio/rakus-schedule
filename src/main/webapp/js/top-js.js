$( function() {
  $('#ui-dialog' ).dialog({
    autoOpen : false,
  });
  $('#ui-dialog-opener').click( function() {
    $('#ui-dialog').dialog('open');
    return false;
  });
});
