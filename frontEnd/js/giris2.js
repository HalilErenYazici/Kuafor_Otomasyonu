$('#loginbtn').on('click', function(event) {
    event.preventDefault(); // Formun doğrudan submit olmasını engeller

    var enteredUsername = $('#eposta').val();
    var enteredPassword = $('#password').val();

    // Kullanıcı adı veya şifre boşsa uyarı ver ve işlemi sonlandır
    if (enteredUsername === '' || enteredPassword === '') {
        alert('Kullanıcı adı veya şifre boş olamaz.');
        return;
    }

    // Admin girişi kontrolü
    $.ajax({
        url: 'http://localhost:8080/api/admin', // Admin bilgilerini çekeceğiniz endpoint
        type: 'GET',
        success: function(adminResponse) {
            var isAdmin = adminResponse.some(function(admin) {
                return admin.email === enteredUsername && admin.sifre === enteredPassword;
            });

            if (isAdmin) {
                alert('Admin girişi başarılı!');
                window.open('Admin.html', '_blank'); // Yeni sekmede admin sayfasını açma
            } else {
                // Admin değilse, müşteri girişi kontrolü
                $.ajax({
                    url: 'http://localhost:8080/api/musteriler',
                    type: 'GET',
                    success: function(musteriResponse) {
                        var isMusteri = musteriResponse.some(function(musteri) {
                            return musteri.eposta === enteredUsername && musteri.musterisifre === enteredPassword;
                        });

                        if (isMusteri) {
                            alert('Müşteri girişi başarılı!');
                            window.open('Hesabim.html', '_blank'); // Yeni sekmede müşteri sayfasını açma
                        } else {
                            // Müşteri değilse, kuaför girişi kontrolü
                            $.ajax({
                                url: 'http://localhost:8080/api/kuaforler',
                                type: 'GET',
                                success: function(kuaforResponse) {
                                    var isKuafor = kuaforResponse.some(function(user) {
                                        return user.eposta === enteredUsername && user.sifre === enteredPassword;
                                    });

                                    if (isKuafor) {
                                        alert('Kuaför girişi başarılı!');
                                        window.open('Kuafor.html', '_blank'); // Yeni sekmede kuaför sayfasını açma
                                    } else {
                                        alert('Kullanıcı bulunamadı veya şifre yanlış!');
                                    }
                                },
                                error: function(kuaforError) {
                                    console.error('Kuaförler API hatası:', kuaforError);
                                }
                            });
                        }
                    },
                    error: function(musteriError) {
                        console.error('Müşteriler API hatası:', musteriError);
                    }
                });
            }
        },
        error: function(adminError) {
            console.error('Admin API hatası:', adminError);
        }
    });
});
