<html lang="en">
<head>
    <title>Irens</title>
</head>
<body>
<form method="post" action="/">
    <input type="text" name="number" placeholder="Number">
    <input type="text" name="range" placeholder="Range">
    <input type="submit">
    <input type="hidden" name="_csrf" value=${_csrf.token}>
</form>
<#if palindromes??>
    <#list palindromes as item>
        <h3>${item}</h3>
    <#else>
        <h1>Empty</h1>
    </#list>
</#if>
</body>
</html>