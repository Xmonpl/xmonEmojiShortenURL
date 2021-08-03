<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>$titleprefix ☕ 404 error</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document)['ready'](function () {

            var _0x399ec4 = {};

            function _0x326088(_0x19a53d, _0x567a79) {
                return Math['round'](Math['random']() * (_0x567a79 - _0x19a53d + 0x1)) + _0x19a53d;
            }
            $(window)['mousemove'](function (_0x32fd1b) {
                _0x399ec4['x'] = _0x32fd1b['pageX'];
                _0x399ec4['y'] = _0x32fd1b['pageY'];
                if (_0x399ec4['x'] > 0x0 && _0x399ec4['y'] > 0x0) {
                    var _0xd6406d = Math['floor'](Math['random']() * random_images_array['length']);
                    var _0x32090d = random_images_array[_0xd6406d];
                    var _0xb9f424 = '<img height=\"25px\" width=\"25px\" src=\"$url' + _0x32090d + '\" alt=\"\" border=\"0\">';
                    var _0x3ab1c1 = 0xa;
                    var _0x5c2c3d = _0x326088(0x2, 0x1);
                    size = 'height:P' + _0x5c2c3d + 'px;Pwidth: ' + _0x5c2c3d + 'px;';
                    var _0x327bff = 'left: ' + _0x326088(_0x399ec4['x'] - _0x3ab1c1 - _0x5c2c3d, _0x399ec4['x'] + _0x3ab1c1) + 'px;';
                    var _0xe8760 = 'top: ' + _0x326088(_0x399ec4['y'] - _0x3ab1c1 - _0x5c2c3d, _0x399ec4['y'] + _0x3ab1c1) + 'px;';
                    var _0x167e83 = _0x327bff + _0xe8760 + size;
                    $('<div class=\'pointer\' style=\'' + _0x167e83 + '\'>' + _0xb9f424 + '</div>')['appendTo']('#xmon')['one']('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
                        $(this)['remove']();
                    });
                }
            });

        });


        var random_images_array = [
            'smiling-face-with-open-mouth-and-cold-sweat_1f605.png',
            'face-with-tears-of-joy_1f602.png',
            'smiling-face-with-smiling-eyes-and-three-hearts_1f970.png'
        ];
    </script>
    <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-7232982354875487" crossorigin="anonymous"></script>
    <meta name="monetization" content="$ilp.uphold.com/rFyDnMq2x6An">
</head>
<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"><style>
    html, body {
        height: 100%;
        margin: 0;
        position: relative;
        background: #1B2A47;
        overflow: hidden;
    }

    body {
        display: -ms-flexbox;
        display: -webkit-box;
        display: flex;
        -ms-flex-align: center;
        -ms-flex-pack: center;
        -webkit-box-align: center;
        align-items: center;
        -webkit-box-pack: center;
        justify-content: center;
        padding-top: 40px;
        padding-bottom: 160px;
        background-color: #212121;
        color: white;
        margin:0;
    }

    .error-header {
        font-weight: 800;
        opacity: .9;
    }

    .error-description {
        font-weight: 400;
        opacity: .8;
    }
    .pointer {
        pointer-events: none;
        position: absolute;
        border-radius: 30%;
        animation: implode 1s ease-in-out;
        animation-fill-mode: both;
        opacity: 1;
    }
    @keyframes implode {
        100% {
            transform: scale(0)
        }
    }

</style>
<div id="xmon"></div>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-3">
            <h2 class="mb-3 error-header">The page you are looking for does not exist <img src="https://cdn.discordapp.com/emojis/714787195461959789.png?v=1" alt="sad cat" style="display:inline-block;" width="50px"></h2>
            <p class="error-description">Unfortunately, there's nothing here. (╯°□°）╯︵ ┻━┻<br>Or the makers want you to think there's nothing here<img src="https://cdn.discordapp.com/emojis/691215016984182804.png?v=1" alt="harold" width="25px"></p>
            <h6 class="error-description" style="opacity: 0.5">404 NOT FOUND</h6>
        </div>
    </div>
</div>
</body>
</html>