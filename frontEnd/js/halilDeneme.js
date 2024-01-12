function hesapAc()
{
    window.open('js/halilDeneme.html');
}

$(document).ready(function () {
    $('#signupBtn').click(function () {
        var username = $('#username').val();
        var surname = $('#surname').val();
        var email = $('#email').val();
        var password = $('#password').val();
        var confirmPassword = $('#confirmPassword').val();
        if(username=="")
        {
            $('#error-message').text('Ad giriniz.');

        }
        else if(surname=="")
        {
            $('#error-message').text('Soyad giriniz.');
        }
        else if(email=="")
        {
            $('#error-message').text('E-posta giriniz.');

        }
        else if (password=="")
        {
            $('#error-message').text('Şifre giriniz.');

        }
        else if (password !== confirmPassword) {
            $('#error-message').text('Şifreler uyuşmuyor.');
        } else {
        const yeniKullanici = {
            musteriisim: $('#username').val(),
            musterisoyisim: $('#surname').val(),
            eposta: $('#email').val(),
            musterisifre: $('#password').val()
        };

        $.ajax({
            url: 'http://localhost:8080/api/musteriler',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(yeniKullanici),
            success: function () {
                
                console.log('Yeni kullanıcı eklendi.');
                alert("Hesabınız Başarıyla Oluşturuldu! Devam Etmek İçin Tıkla.");
                window.close();
                refreshTable();
            },
            error: function (xhr, textStatus, errorThrown) {
                console.error('Yeni kullanıcı ekleme hatası:', xhr.responseJSON.message);
                alert("Error: Bu mail adresi kullanılıyor olabilir. Farklı bir mail giriniz.")
                if (xhr.status === 500 && xhr.responseJSON.error === 'EmailAlreadyExists') {
                    $('#error-message').text('Error: bu mail adresi kullanılıyor farklı mail gir');
                } else {
                    $('#error-message').text('Error: ' + xhr.responseJSON.message);
                
                }
            }
        });
        }
    });
});
$(document).ready(function () {
    function refreshTable() {
        $.ajax({
            url: 'http://localhost:8080/api/musteriler',
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                console.log(json);

                const kullaniciListesiHTML = json.map(kullanici => `
                    <tr>
                        <td>${kullanici.musteriisim} ${kullanici.musterisoyisim}</td>
                        <td>${kullanici.eposta}</td>
                        <td>${kullanici.musterisifre}</td>


                        <td><button class="btn btn-danger btn-sm deleteBtn" data-id="${kullanici.id}">Sil</button>
                        <button class="btn btn-primary btn-sm editBtn" data-id="${kullanici.id}">Düzenle</button>

                        </td>

                    </tr>
                `).join('');

                $('#musteriListesi').html(kullaniciListesiHTML);

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
            url: `http://localhost:8080/api/musteriler/${id}`,
            type: 'DELETE',
            success: function () {
                console.log(`Kullanıcı ID ${id} silindi.`);
                alert("Kullanıcı Silindi. Devam Etmek İçin Tıkla.")
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
            url: `http://localhost:8080/api/musteriler/${id}`,
            type: 'GET',
            dataType: 'json',
            success: function (kullanici) {
                $('#guncelleId').val(kullanici.id);
                $('#guncelleIsim').val(kullanici.musteriisim);
                $('#guncelleSoyisim').val(kullanici.musterisoyisim);
                $('#guncelleEposta').val(kullanici.eposta);
                $('#guncelleSifre').val(kullanici.musterisifre);

            },
            error: function (error) {
                console.error('Kullanıcı bilgisi getirme hatası:', error);
            }
        });
    }

    $('#guncelleBtn').click(function () {
        const kullaniciId = $('#guncelleId').val();
        const guncellenmisKullanici = {
            musteriisim: $('#guncelleMusteriIsim').val(),
            musterisoyisim: $('#guncelleMusteriSoyisim').val(),
            eposta: $('#guncelleMusteriEposta').val(),
            musterisifre: $('#guncelleMusteriSifre').val()

        };

        $.ajax({
            url: `http://localhost:8080/api/kuaforler/${kullaniciId}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(guncellenmisKullanici),
            success: function () {
                console.log(`Kullanıcı ID ${kullaniciId} güncellendi.`);
                refreshTable();
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
    })})
