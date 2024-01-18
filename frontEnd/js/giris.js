// login-script.js

/*$(document).ready(function(){
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
*/
$(document).ready(function() {
    $('#loginForm').submit(function(event) {
        event.preventDefault();

        var email = $('#email').val();
        var password = $('#password').val();

        var data = {
            email: email,
            password: password
        };

        fetch('http://localhost:8082/api/kuaforler', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Giriş başarısız.');
            }
            return response.json();
        })
        .then(data => {
            console.log('Başarılı:', data);
            localStorage.setItem('sessionKey', data.sessionKey);
            localStorage.setItem('userId', data.id);
            localStorage.setItem('userName', data.firstName); 
            localStorage.setItem('userRole', data.role);
            
            window.location.href = 'homePage.html';
            alert('Hoşgeldin '+data.firstName );
        })
        .catch((error) => {
            console.error('Hata:', error);
            document.getElementById('dangerContainer').style.display = 'block';
            setTimeout(function() {
                document.getElementById('dangerContainer').style.display = 'none';
            }, 3000); 
        });
    });
})
