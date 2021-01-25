function getSearch() {
  $('#bloc_m').animate({opacity:.5});
  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'phones.json', false);
  xhr.send();
  if (xhr.status != 200) { // обработать ошибку
    alert('Ошибка ' + xhr.status + ': ' + xhr.statusText);
  } else { // вывести результат
    alert(xhr.responseText);
  }
}
