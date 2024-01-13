$(document).ready(function () {
    
    function refreshTable() {
        $.ajax({
            url: 'http://127.0.0.1:8080/api/musteriler/7',
            type: 'GET',
            dataType: 'json',
            success: function (kullanici) {
                console.log(kullanici);

                const kullaniciHTML = `
                    <p>Kullanıcı id : ${kullanici.id}</p>
                    <p>Kullanıcı Adı Soyadı : ${kullanici.musteriisim} ${kullanici.musterisoyisim}</p>
                    <p style="font-size: 33px;">Kullanıcı Eposta: ${kullanici.eposta}</p>
                    <p>Kullanıcı Sifre: ${kullanici.sifre}</p>

                    <p>
                        <button class="btn btn-danger btn-sm deleteBtn" data-id="${kullanici.id}">Sil</button>
                        <button class="btn btn-primary btn-sm editBtn" data-id="${kullanici.id}">Düzenle</button>
                    </p>
                `;

                $('#kullaniciListesi').html(kullaniciHTML);

                $('.deleteBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    deleteKullanici(kullaniciId);
                });

                $('.editBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    
                    showEditForm(kullaniciId);
                    $("#guncelleForm").show(1000);

                });
            },
            error: function (error) {
                console.error('Veri çekme hatası:', error);
            }
        });
    }

    refreshTable();
    function deleteKullanici(id) {
        $.ajax({
            url: `http://localhost:8080/api/kuaforler/${id}`,
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
    $('#guncelleBtn').click(function () {
        const kullaniciId = $('#guncelleId').val();
        const guncellenmisKullanici = {
            musteriisim: $('#guncelleIsim').val(),
            musterisoyisim: $('#guncelleSoyisim').val(),
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
                refreshTable();
                $('#guncelleForm').hide();
            },
            error: function (xhr, textStatus, errorThrown) {
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

});
