<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        
        <title>@yield('title', 'BikeShop | Sell bycicle gear')</title>
        <!-- css -->
        <link rel="stylesheet" href="{{ asset('vendor/bootstrap/css/bootstrap.min.css') }}">
        <link rel="stylesheet" href="{{ asset('vendor/font-awesome/css/all.min.css') }}">
        <link rel="stylesheet" href="{{ asset('vendor/toastr/toastr.min.css') }}">
        <link rel="stylesheet" href="{{ asset('css/style.css') }}">
        <!-- jss -->
        <script src="{{ asset('js/jquery-3.7.0.min.js') }}"></script>
        <script src="{{ asset('vendor/toastr/toastr.min.js') }}"></script>
    </head>

    <body>
        <script src="{{ asset('vendor/bootstrap/js/bootstrap.min.js') }}"></script>
        <div class="container">
            <!-- conent here -->
            <nav class="navbar navbar-default navbar-static-top">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BikeShop</a>
                </div>

                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Home</a></li>
                        <li><a href="{{ URL::to('product') }}">Products</a></li>
                        <li><a href="{{ URL::to('category') }}">Category</a></li>
                        <li><a href="#">Report</a></li>
                        
                    </ul>
                </div>
            </nav>
            <center><h1> 6406021620092 นายธนกฤต วงศ์สาธิตา </h1></center>

            @yield('content')
                @if(session('msg'))
                    @if(session('ok'))
                        <script>toastr.success("{{ session('msg') }}")</script>
                    @else
                        <script>toastr.error("{{ session('msg') }}")</script>
                    @endif
                @endif

                <script src="{{ asset('vendor/bootstrap/js/bootstrap.min.js') }}"></script>
            <!-- <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        <strong> Topic </strong>
                    </div>
                </div>

                <div class="panel-body">
                    Input detail here.

                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th> Product ID </th>
                                <th> Product Name </th>
                                <th> Product Prize </th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td> P001 </td>
                                <td> เสือหมอบ JAVA </td>
                                <td> 11900 </td>
                            </tr>

                            <tr>
                                <td> P002 </td>
                                <td> เสือหมอบ วินเทจ Cannello Silvia </td>
                                <td> 5000 </td>
                            </tr>

                            <tr>
                                <td> P003 </td>
                                <td> เสือหมอบ Panther March </td>
                                <td> 6500 </td>
                            </tr>

                        </tbody>

                    </table>

                    <a href="#" class="btn btn-default"> Default </a>
                    <a href="#" class="btn btn-primary"> Primary </a>
                    <a href="#" class="btn btn-info"> Info </a>
                    <a href="#" class="btn btn-success"> Success </a>
                    <a href="#" class="btn btn-warning"> Warning </a>
                    <a href="#" class="btn btn-danger"> Danger </a>

                    <div class="from-inline">
                        <input type="text" class="from-control" placeholder="User name">
                        <input type="password" class="from-control" placeholder="Pasword">
                        <a href="#" class="btn btn-primary"> Login </a>

                    </div>

                    <div class="form-group has-error">
                        <label> Name-Surname </label>
                        <input type="text" class="form-control">
                        <div class="help-block"> Please input your name </div>
                    
                    </div>

                    <div class="form-group has-error">
                        <label> Adress </label>
                        <textarea rows="4" class="form-control"></textarea>
                        <div class="help-block"> Please input your adress </div>
                    
                    </div>
                    
                    <div class="form-group">
                        <button class="btn btn-primary"> Add info </button>
                    
                    </div>

                    <div class="alert alert-success alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
                        <strong> Success </strong> Text

                    </div>

                    <div class="alert alert-info alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
                        <strong> Info </strong> Text

                    </div>

                    <div class="alert alert-warning alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
                        <strong> Warning </strong> Text

                    </div>

                    <div class="alert alert-danger alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
                        <strong> Danger </strong> Text

                    </div>

                    <a href="#" class="btn btn-default"><i class="fa fa-home"></i> Home </a>
                    <a href="#" class="btn btn-primary"><i class="fa fa-save"></i> Save </a>
                    <a href="#" class="btn btn-info"><i class="fa fa-edit"></i> Edit </a>
                    <a href="#" class="btn btn-danger"><i class="fa fa-trash"></i> Delete </a>

                    <script>
                        toastr.success("Save successfully");
                        toastr.error("Save fail");
                        
                        
                    </script>

                </div>

            </div> -->

        </div>

    </body>

</html>