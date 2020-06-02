<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/main" method="post">
    Выберите город:<label>
        <select name="cityId">
            <option value="700568">Mykolaiv</option>
            <option value="703448">Kyiv</option>
            <option value="706483">Kharkiv</option>
            <option value="524894">Moscow</option>
            <option value="536203">Saint Petersburg</option>
            <option value="5128581">New York City</option>
            <option value="3169070">Rome</option>
            <option value="5603240">Paris</option>
            <option value="1850147">Tokyo</option>
        </select>
    </label>
    <input type="submit">
</form>
<#if weather??>
    Description:${weather.description}
    <br>
    Temperature:${weather.temperature}
    <br>
    Pressure:${weather.pressure}
    <br>
    Humidity:${weather.humidity}
</#if>
</body>
</html>