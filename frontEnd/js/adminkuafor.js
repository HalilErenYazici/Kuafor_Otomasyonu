function start() {
    var panel = document.getElementById('ekleForm');
    panel.style.display = 'none';
}
function panelEkle(){
    $('#ekleForm').show();
    $('#goruntule').hide();
    $('#kuaforEkleButton').hide();
}
function ekleIptal(){
    $('#ekleForm').hide();
    $('#guncelleForm').hide();
    $('#goruntule').show();
    $('#kuaforEkleButton').show();

}



$(document).ready(function () {
    function refreshTable() {
        $.ajax({
            url: 'http://localhost:8080/api/kuaforler',
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                console.log(json);

                const kullaniciListesiHTML = json.map(kullanici => `
                    <tr>
                        <td>${kullanici.isim} ${kullanici.soyisim}</td>
                        <td>${kullanici.eposta}</td>
                        <td>${kullanici.sifre}</td>


                        <td><button class="btn btn-danger btn-sm deleteBtn" data-id="${kullanici.id}">Sil</button>
                        <button class="btn btn-primary btn-sm editBtn" data-id="${kullanici.id}">Düzenle</button>

                        </td>

                    </tr>
                `).join('');

                $('#kullaniciListesi').html(kullaniciListesiHTML);

                $('.deleteBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    deleteKullanici(kullaniciId);
                });
                 $('.editBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    showEditForm(kullaniciId);
                });
   
            },
            error: function (error) {
                console.error('Veri çekme hatası:', error);
            }
        });
    }

    function deleteKullanici(id) {
        $.ajax({
            url: `http://localhost:8080/api/kuaforler/${id}`,
            type: 'DELETE',
            success: function () {
                console.log(`Kullanıcı ID ${id} silindi.`);
                alert("Kullanıcı Silindi. Devam Etmek İçin Tıkla.");
                $('#guncelleForm').hide();
                refreshTable();
            },
            error: function (error) {
                console.error(`Kullanıcı silme hatası:`, error);
            }
            
        });
    }

    refreshTable();
    function showEditForm(id) {
        $.ajax({
            url: `http://localhost:8080/api/kuaforler/${id}`,
            type: 'GET',
            dataType: 'json',
            success: function (kullanici) {
                $('#guncelleId').val(kullanici.id);
                $('#guncelleIsim').val(kullanici.isim);
                $('#guncelleSoyisim').val(kullanici.soyisim);
                $('#guncelleEposta').val(kullanici.eposta);
                $('#guncelleSifre').val(kullanici.sifre);

                $('#guncelleForm').show();
                $('#ekleForm').hide();
                $('#goruntule').hide();
                $('#kuaforEkleButton').hide();

            },
            error: function (error) {
                console.error('Kullanıcı bilgisi getirme hatası:', error);
            }
        });
    }

    $('#guncelleBtn').click(function () {
        const kullaniciId = $('#guncelleId').val();
        const guncellenmisKullanici = {
            isim: $('#guncelleIsim').val(),
            soyisim: $('#guncelleSoyisim').val(),
            eposta: $('#guncelleEposta').val(),
            sifre: $('#guncelleSifre').val()

        };

        $.ajax({
            url: `http://localhost:8080/api/kuaforler/${kullaniciId}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(guncellenmisKullanici),
            success: function () {
                console.log(`Kullanıcı ID ${kullaniciId} güncellendi.`);
                alert("Kullanıcı Güncellendi. Devam Etmek İçin Tıkla.")
                refreshTable();
                $('#guncelleForm').hide();
                $('#kuaforEkleButton').show();
                $('#goruntule').show();
            },
            error: function (error) {
                console.error('Kullanıcı güncelleme hatası:', xhr.responseJSON.message);

                if (xhr.status === 400 && xhr.responseJSON.error === 'EmailAlreadyExists') {
                    $('#error-message').text('Error: bu mail adresi kullanılıyor farklı mail gir');
                } else {
                    
                    $('#error-message').text('Error: ' + xhr.responseJSON.message);
                }          
              }
        });
    });

    refreshTable();

    $(document).ready(function () {
        $('#ekleFormBtn').click(function () {
            const yeniKullanici = {
                isim: $('#ekleIsim').val(),
                soyisim: $('#ekleSoyisim').val(),
                eposta: $('#ekleEposta').val(),
                sifre: $('#ekleSifre').val()
            };
    
            $.ajax({
                url: 'http://localhost:8080/api/kuaforler',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(yeniKullanici),
                success: function () {
                    
                    console.log('Yeni kullanıcı eklendi.');
                    $('#ekleForm').hide();
                    $('#kuaforEkleButton').show();
                    $('#goruntule').show();
                    refreshTable();
                },
                error: function (xhr, textStatus, errorThrown) {
                    console.error('Yeni kullanıcı ekleme hatası:', xhr.responseJSON.message);
    
                    if (xhr.status === 500 && xhr.responseJSON.error === 'EmailAlreadyExists') {
                        alert("Error: bu mail adresi kullanılıyor farklı mail gir")
                        $('#error-message').text('Error: bu mail adresi kullanılıyor farklı mail gir');
                    } else {
                        $('#error-message').text('Error: ' + xhr.responseJSON.message);
                    
                    }
                }
            });
        });
    });
    

});