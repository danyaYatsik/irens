<head>
    <meta charset="UTF-8" content="text/html">
    <title>Irens</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-5 p-3">
    <div class="row ml-5">
        <form method="post" action="/">
            <div class="form-group-light offset-2 col-4">
                <label class="">Number</label>
                <div>
                    <input id="number" type="text" name="number">
                </div>
                <label>Number of palindromes</label>
                <div>
                    <input id="range" type="number" name="range">
                </div>
                <button id="submit" class="btn btn-primary-dark mt-2" type="submit">Find</button>
                <#--<input type="hidden" name="_csrf" value=${_csrf.token}>-->

            </div>
        </form>
        <div class="col-4 offset-2">
            <h2 id="history" <#if palindromes?size == 0>class="hidden"</#if>>History</h2>
            <div class="list-group">
                <#list palindromes as item>
                    <div class="list-group-item list-group-item-light">
                        ${item.origin}
                        <hr/>
                        <span class="hidden number-id">${item.id}</span>
                        <button class="btn btn-primary-light ml-2">Show</button>
                    </div>
                </#list>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="application/javascript" src="js/main.js"></script>
    </div>
</div>
</body>