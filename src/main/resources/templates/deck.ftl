<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Table</title>
</head>
<body style="background: grey">

<button ><a href="/web/cards/stop">STOP</a></button>
<p class="background">

<#--<span><img id="bild" src="https://luxfon.com/pic/201203/1920x1080/luxfon.com-364.jpg">-->
<div>
    <h1>ROUND ${round}</h1>
</div>
<div style="display: flex; justify-content: center;align-content: center; height: 100%">
    <div class="wrap" style="width: 500px; height: 500px;background: green">
        <div class="table"><a href="/web/cards/pick">
                <img style=" justify-content: center; width: 70px" src="/img/img_1.png" alt="lol">
            </a>
        </div>

        <div style="position: absolute">
        <#--        ${card.suit}-->
        <#--        ${card.nominal}-->
        <#--        <img src="${card.img}" alt="${card.img}" style="height: 120px;width: 70px">-->
        <#--<div><img style=" justify-content: center; width: 70px" src="/img/img_1.png" alt="lol"></div>-->

        <h3>${sum}</h3>
        <#list delivery as card>
            <ul style="float: left">
                <li style="display: block">
             <img src="${card.img}" style="height: 70px; width: 35px">
                </li>
            </ul>
        </#list>
            <div class="message">
                <#--<a style="padding-left: 50%">${message}</a>-->
            </div>
        </div>
    </div>
</div>
<p/>
</body>
</html>