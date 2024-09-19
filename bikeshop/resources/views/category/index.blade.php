@extends('layouts.master')
@section('title') BikeShop | CategoryList @stop
@section('content')
    <h1>Category List</h1>
    <div class="panel panel-default">
        
        <div class="panel-heading">
            <div class="panel-title"><strong>List</strong></div>
        </div>

        <div class="panel-body">
            <form action="{{ URL::to('category/search') }}" method="post" class="form-inline">
                {{ csrf_field() }}
                <input type="text" name="q" class="form-control" placeholder="...">
                <button type="submit" class="btn btn-primary"> Search </button>
            </form>

            <a href="{{ URL::to('category/edit/') }}" class="btn btn-success pull-right">Add category</a>
        
            <table class="table table-bordered bs_table">
                <thead>
                    <tr>
                        <th> Category Id </th>
                        <th> Category name </th>
                        <th> Category use </th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($category as $p)
                        <tr>
                            <td>{{ $p->id }}</td>
                            <td>{{ $p->name }}</td>
                            <td class="bs_center">
                                <a href="{{ URL::to('category/edit/'.$p->id) }}" class="btn btn-info"><i class="fa fa-edit"> Edit </i></a>
                                <a href="#" class="btn btn-danger btn-delete " id-delete="{{ $p->id }}">
                                    <i class="fa fa-trash"> Delete </i>
                                </a>
                            </td>
                        </tr>
                    @endforeach
                </tbody>
                <tfoot>
                    <tr>
                        <th colspan="4"> All </th>
                    </tr>
                </tfoot>
            </table>

        </div>

        <div class="panel-footer">
            <div class="container">
                {{$category->links()}}
            </div>
            <span>have {{ count($category)}} list</span>
        </div>

        <script>
            // ใช้เทคนิค jQuery
            $('.btn-delete').on('click', function() { if(confirm("คุณต้องการลบข้อมูลสินค้าหรือไม่?")) {
            var url = "{{ URL::to('category/remove') }}"
            + '/' + $(this).attr('id-delete'); window.location.href = url;
            }
            });
        </script>

    </div>
@endsection