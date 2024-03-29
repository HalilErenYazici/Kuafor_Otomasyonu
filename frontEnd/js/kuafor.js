// your-script.js

$(document).ready(function () {
    function refreshTable() {
        $.ajax({
            url: 'http://127.0.0.1:8080/api/randevu',
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                console.log(json);

                const kullaniciListesiHTML = json.map(kullanici => `
                    <tr data-id="${kullanici.id}">
                        <td>${kullanici.musteriisim}</td>
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

                $('.deleteBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    deleteKullanici(kullaniciId);
                });

                $('.successBtn').click(function () {
                    const kullaniciId = $(this).data('id');
                    console.log('successBtn clicked with id:', kullaniciId);
                    updateBackground(kullaniciId);
                });
            },
            error: function (error) {
                console.error('Veri çekme hatası:', error);
            }
        });
    }

    function deleteKullanici(id) {
        $.ajax({
            url: `http://localhost:8080/api/randevu/${id}`,
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

    function updateBackground(id) {
        console.log('updateBackground called with id:', id);
    
        // Tüm satırların arka plan rengini temizle
        $('tr[data-id]').removeClass('highlighted');
    
        // Sadece tıklanan satırın arka plan rengini güncelle
        $(`tr[data-id="${id}"]`).addClass('highlighted');
    }

    refreshTable();
});
