<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Table</title>
</head>
<body style="background: grey">

<a href="/web/cards/refresh">
<button >New Game</button>
</a>
<a href="/web/cards/game">
<button >next Raund</button>
</a>

<a class="btnStop" href="/web/cards/stop">
    <button>Stop</button>
</a>
<p class="background">
<div style="display: flex; justify-content: center;align-content: center; height: 100%">
    <div class="wrap" style="width: 500px; height: 500px;background: green">
        <div class = "table" style="margin-left: 200px;"><a href="#">
                <div>
                    <h1>ROUND ${round}</h1>
                    <h2>Player ${score} PC</h2>
                </div>
                <img style=" justify-content: center; width: 70px" src="/img/img_1.png" alt="lol">
            </a>
        </div>
        <div style="position: absolute">
            <h3>${sum2}</h3>
        <#list pcdelivery as card>
            <ul style="float: left">
                <li style="display: block">
             <img src="${card.img}" style="height: 70px; width: 35px">
                </li>
            </ul>
        </#list>
            </div>
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
    <div class="messagePc">
        <a style="padding-left: 50%">${message}</a>
    </div>
</div>
</div>
<p/>
</body>
</html>