function getSearch() {
  //var table = document.getElementById("generator_t");
 // while(table.rows.length > 1) {
  //  table.deleteRow(1);
  //}
  var country = $('select option:selected').text();
  var min = document.getElementById('minRang').value;
  var max = document.getElementById('maxRang').value;

  var body = 'country=' + country +
      '&min=' + min +
      '&max=' + max;
    /*
  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'search.json', false);
  xhr.send(body);
  if (xhr.status != 200) {
    alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
  } else {
    var s = xhr.responseText;
    var myObject = eval('(' + s + ')');

    for (i in myObject)
    {
       var tbodyOfTable = document.querySelector('#generator_t tbody');
       var listOfTr = tbodyOfTable.children;
       var newTr = document.createElement('tr');
       newTr.innerHTML = '<td><a href="'+myObject[i]["link"]+'"><img src="'+ myObject[i]["img"] +'"></a></td><td>'+myObject[i]["name"]+'</td><td>'+myObject[i]["price"]+'</td><td>'+myObject[i]["country"]+'</td><td>'+myObject[i]["weight"]+'</td>';
       tbodyOfTable.insertBefore(newTr, listOfTr[(listOfTr.length)]);
    }
  } */
}

