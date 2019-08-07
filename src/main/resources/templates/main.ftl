<!DOCTYPE html>
<html lang="en">
<head>
    <title>Irens</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form method="post" action="/">
        <div class="form-group col-4">
            <label class="">Number</label>
            <div>
                <input type="text" name="number">
            </div>
            <label>Range</label>
            <div>
                <input type="number" name="range">
            </div>
            <button class="btn btn-primary-dark mt-2" type="submit">Find</button>
            <input type="hidden" name="_csrf" value=${_csrf.token}>

        </div>
    </form>
    <div class="col-4 ms-3">
        <#list palindromes>
            <h2>History</h2>
            <#items as item>
                <div class="list-group-item list-group-item-dark">
                    Number - ${item.origin}, min - ${item.min}, max - ${item.max}</div>
            </#items>
        </#list>
    </div>
</div>
<script  src="/main.js"></script>
</body>
</html>