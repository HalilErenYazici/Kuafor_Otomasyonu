
$(document).ready(function () {
    // ...
    $.ajax({
        url: 'http://localhost:8080/api/kuaforler',
        method: 'GET',
        dataType: 'json',
        success: function(data) {
          // ComboBox'a veriyi ekleme
          var kuafor = $('#kuafor');
          
          $.each(data, function(index, item) {
            // Ad ve soyad bilgisini birleştirerek option'a ekleyin
            var fullName = item.isim + ' ' + item.soyisim;
            kuafor.append('<option value="' + item.id + '">' + fullName + '</option>');
          });
        },
        error: function(error) {
          console.log('API veri çekme hatası:', error);
        }
      });
    $('#onayla').click(function () {
        const yeniRandevu = {
            Musteriisim: $(null).val(),

            KuaforAd: $('#kuafor').val(),
            islem: $('#islem').val(),
            Gun: $('#gun').val(),
            saat: $('#saat').val(),
            onay: $('#onay').val()

        };

        $.ajax({
            url: 'http://localhost:8080/api/randevu',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(yeniRandevu),
            success: function () {
                console.log('Yeni mesaj eklendi.');
                refreshTable(); // Yeni mesaj ekledikten sonra tabloyu güncelle
            },
            error: function (xhr, textStatus, errorThrown) {
                console.error('Yeni mesaj ekleme hatası:', xhr.responseJSON.message);
                $('#error-message').text('Error: ' + xhr.responseJSON.message);
            }
        });
    });

    // Burada birinci document.ready fonksiyonu kapatılıyor

    // İkinci document.ready fonksiyonu başlatılıyor
   //document.ready fonksiyonu kapatılıyor

    // Burada başka kodlar olabilir...

});