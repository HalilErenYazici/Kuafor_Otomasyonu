$(document).ready(function () {
    // ...

    $('#onayla').click(function () {
        const yeniBizeUlas = {
            
            adsoyad: $('#adsoyad').val(),
            email: $('#Email').val(),
            telefon: $('#telefon').val(),
            adres: $('#adres').val(),
            mesaj: $('#mesaj').val()
        };

        $.ajax({
            url: 'http://localhost:8080/api/bizulasin',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(yeniBizeUlas),
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

}); // En dıştaki document.ready fonksiyonu kapatılıyor
$(document).ready(function () {
    function refreshTable() {
        $.ajax({
            url: 'http://127.0.0.1:8080/api/bizulasin',
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                console.log(json);

                const kullaniciListesiHTML = json.map(kullanici => `
                    <tr>
                        <td>${kullanici.adsoyad}</td>
                        <td>${kullanici.email}</td>
                        <td>${kullanici.telefon}</td>
                        <td>${kullanici.adres}</td>
                        <td>${kullanici.mesaj}</td>


                        <td><button class="btn btn-danger btn-sm deleteBtn" data-id="${kullanici.id}">X</button>

                        </td>

                    </tr>
                `).join('');

                $('#bizeliste').html(kullaniciListesiHTML);

                $('.deleteBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    deleteKullanici(kullaniciId);
                });
              
   
            },
            error: function (error) {
                console.error('Veri çekme hatası:', error);
            }
        });
    }

    function deleteKullanici(id) {
        $.ajax({
            url: `http://localhost:8080/api/bizulasin/${id}`,
            type: 'DELETE',
            success: function () {
                console.log(`Kullanıcı ID ${id} silindi.`);
                refreshTable();
            },
            error: function (error) {
                console.error(`Kullanıcı silme hatası:`, error);
            }
        });
    }

    refreshTable();
  
});