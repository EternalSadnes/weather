<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather</title>
</head>
<body>
<form action="/main" method="post">
    Choose city:<label>
        <select name="cityId">
            <#list cities as city,cityId>
                <option value="${cityId}">${city}</option>
            </#list>
        </select>
    </label>
    <input type="submit">
</form>
<#if weather??>
    Right now in ${weather.city}: ${weather.description}
    <br>
    <br>
    Temperature: ${weather.temperature} ℃
    <br>
    <br>
    Pressure: ${weather.pressure}
    <br>
    <br>
    Humidity: ${weather.humidity}%
    <br>
    <br>
    Wind speed: ${weather.wind} m/s
    <br>
    <br>
    Clouds:${weather.clouds} %
    <br>
    <br>
    <#if weather.visibility??>
        Visibility: ${weather.visibility}
        <br>
        <br>
    </#if>
</#if>
</body>
</html>