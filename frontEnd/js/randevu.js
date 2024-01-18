$(document).ready(function () {
  var secilenDeger;  // secilenDeger'i global olarak tanımla

  $.ajax({
      url: 'http://localhost:8080/api/kuaforler',
      method: 'GET',
      dataType: 'json',
      success: function (data) {
          var kuafor = $('#kuafor');

          $.each(data, function (index, item) {
              var fullName = item.isim + ' ' + item.soyisim;
              kuafor.append('<option value="' + fullName + '">' + fullName + '</option>');
          });
      },
      error: function (error) {
          console.log('API veri çekme hatası:', error);
      }
  });

  $('#kuafor').change(function () {
      secilenDeger = $(this).val();  // secilenDeger'i güncelle
      $('#sonucParagrafi').text(secilenDeger);
  });

  $('#onayla').click(function () {
     var Musteriisim = $('#musteriAd').val();

      var islem = $('#islem').val();
      var gun = $('#gun').val();
      var saat = $('#saat').val();
      var onay = $('#onay').val();

      var yeniRandevu = {
        musteriisim: Musteriisim,
          kuaforAd: secilenDeger,  // secilenDeger'i kullan
          islem: islem,
          gun: gun,
          saat: saat,
          onay: onay
      };

      $.ajax({
          url: 'http://localhost:8080/api/randevu',
          type: 'POST',
          contentType: 'application/json',
          data: JSON.stringify(yeniRandevu),
          success: function () {
              console.log('Yeni randevu eklendi.');
              // İlgili işlemleri burada gerçekleştirin
          },
          error: function (xhr, textStatus, errorThrown) {
              console.error('Yeni randevu ekleme hatası:', xhr.responseJSON.message);
              // Hata durumunda gerekli işlemleri burada gerçekleştirin
              $('#error-message').text('Error: ' + xhr.responseJSON.message);
          }
      });
  });
});



$(document).ready(function () {
  function refreshTable() {
      $.ajax({
          url: 'http://127.0.0.1:8080/api/randevu',
          type: 'GET',
          dataType: 'json',
          success: function (json) {
              console.log(json);

              const kullaniciListesiHTML = json.map(kullanici => `
                  <tr>
                      <td>${kullanici.Musteriisim}</td>
                      <td>${kullanici.kuaforAd}</td>
                      <td>${kullanici.islem}</td>
                      <td>${kullanici.gun}</td>
                      <td>${kullanici.saat}</td>
                      <td>${kullanici.onay}</td>
                      <td>
                          <button class="btn btn-danger btn-sm deleteBtn" data-id="${kullanici.id}">X</button>
                          <button class="btn btn-success btn-sm successBtn" data-id="${kullanici.id}">V</button>
                      </td>
                  </tr>
              `).join('');

              $('#randevueliste').html(kullaniciListesiHTML);

          },
          error: function (error) {
              console.error('Veri çekme hatası:', error);
          }
      });
  }

  
  
  
  
  
  refreshTable();
});