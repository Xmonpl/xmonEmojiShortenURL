<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>$titleprefix</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/css/bootstrap.min.css" integrity="sha512-usVBAd66/NpVNfBge19gws2j6JZinnca12rAe2l+d+QkLU9fiG02O1X8Q6hepIpr/EYKZvKx/I9WsnujJuOmBA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        @import url(https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap);
        body {
            font-family: "Poppins", sans-serif;
            overflow-x: hidden;
            overflow-y: hidden;
            display: flex;
            min-height: 100vh;
            flex-direction: column;
            background: #f2f2f2;

        }
        .xmon-banner {
            background: url('$url/right-image.webp');
            background-size: cover;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            -ms-background-size: cover;
            background-attachment: fixed;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }

        .xmon-banner h3 {
            font-size: 54px;
            line-height: 64px;
            font-weight: 300;
        }

        .xmon-banner h3 span {
            font-weight: bold;
        }

        @media (max-width: 1200px) {
            .xmon-banner h3 {
                font-size: 50px;
                line-height: 64px;
            }
        }

        @media (max-width:900px) {
            .xmon-banner h3 {
                font-size: 45px;
                line-height: 55px;
            }
        }

        @media (max-width: 480px) {
            .xmon-banner h3 {
                font-size: 40px;
                line-height: 50px;
            }
        }
        .btn-style {
            padding: 14px 30px;
            font-weight: 600;
            font-size: 16px;
            color: #fff;
            text-transform: uppercase;
            border-radius: 30px;
            background: #feb000;
            border: none;
            transition: all .25s ease-in-out;
        }
    </style>
    <meta name="monetization" content="$ilp.uphold.com/rFyDnMq2x6An">
    <script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-7232982354875487" crossorigin="anonymous"></script>
</head>

<body>
<div class="modal fade" id="shorturl" tabindex="-1" data-bs-backdrop="static" aria-labelledby="exampleModalLabel" aria-hidden="true" style="background-color: rgba(0, 0, 0, 0.2) !important;backdrop-filter: blur(10px) saturate(125%);
        -webkit-backdrop-filter: blur(10px) saturate(125%);">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
        <div class="modal-content" style="background-color: #ffffff;">
            <div class="modal-header">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="color: white; background-color: white;"></button>
            </div>
            <div class="modal-body">
                <form action="#">
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="addon-wrapping">Long link</span>
                        <input type="text" class="form-control" placeholder="https://www.youtube.com/watch?v=QROvuMP-Nws" aria-label="Long link" aria-describedby="addon-wrapping" id="shorturl321" required>
                        <button type="submit" class="btn btn-style" onclick="shortURL();" >SHORT URL</button>
                        <h2 id="success"></h2>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<header>
    <nav class="navbar navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="https://xmon.eu.org/media/images/logo.webp" alt="" style="max-width: 8%;" class="d-inline-block align-text-top">
                <span style=" display: inline-block; vertical-align: bottom;">$titleprefix</span>
            </a>
        </div>
    </nav>
</header>

<section id="home" class="xmon-banner py-5" style="margin-left: -25px!important;">
    <div class="container pt-5 pb-md-4">
        <div class="row align-items-center">
            <div class="col-md-6 pt-md-0 pt-4">
                <h3 class="mb-sm-4 mb-3 title">Free
                    <span>Emoji links!</span></h3>
                <p>Shorten your long link to a minimized version with a cool look 😎</p>
                <div class="mt-md-5 mt-4 mb-lg-0 mb-4">
                    <button type="button" class="btn btn-style" data-bs-toggle="modal" data-bs-target="#shorturl"> SHORT URL</button>
                    <img class="img-fluid" src="https://i.xmon.eu.org/raw/d0cc6e85-65d8-420e-a11e-48377b5bb4e4" alt="https://i.xmon.eu.org/raw/d0cc6e85-65d8-420e-a11e-48377b5bb4e4" >
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.bundle.min.js" integrity="sha512-72WD92hLs7T5FAXn3vkNZflWG6pglUDDpm87TeQmfSg8KnrymL2G30R7as4FmTwhgu9H7eSzDCX3mjitSecKnw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    function shortURL(){
        $('#shorturl').modal('hide');
        console.log(document.getElementById("shorturl321").value);
        $.ajax({
            method:"POST",
            url: "$url/api/v1/short",
            data: {"url": document.getElementById("shorturl321").value, "size": 6 }
        }).done(function(response){
            Swal.fire({
                title: 'Your cool short link 😎',
                input: 'text',
                inputValue: response['data'],
                icon: 'success'
            });
            $( "input.swal2-input" ).select();
            document.execCommand("Copy");
        });
    }

</script>
</body>

</html>