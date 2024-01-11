// login-script.js

$(document).ready(function(){
    $("#loginButton").click(function(){
        var eposta = $("#email").val();
        var sifre = $("#sifre").val();
        
        // Kullanıcı girişi için API isteği gönder
        $.ajax({
            url: 'http://localhost:8080/api/kuaforler', // API'nizin giriş endpoint'ini buraya ekleyin
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ eposta: eposta, sifre: sifre }),
            success: function(response){
                console.log(response);

                // Giriş başarılıysa, API'den dönen token'ı kullanıcı cihazına kaydedin
                localStorage.setItem('authToken', response.token);

                // İstediğiniz diğer işlemleri gerçekleştirin
                alert("Giriş başarıyla gerçekleştirildi!");
                window.location.href = "dashboard.html";
            },
            error: function(error){
                console.error('Giriş hatası:', error);
                // Giriş başarısızsa, kullanıcıya uygun bir geri bildirim gösterin
                alert("Giriş başarısız. Lütfen e-posta ve şifrenizi kontrol edin.");
            }
        });
    });

    // Diğer fonksiyonları ve event dinleyicilerini ekleyebilirsiniz
    // ...
});
