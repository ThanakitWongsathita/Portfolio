@extends('layouts.master')
@section('title') BikeShop | ProductList @stop
@section('content')
    <h1>Product List</h1>
    <div class="panel panel-default">
        
        <div class="panel-heading">
            <div class="panel-title"><strong>List</strong></div>
        </div>

        <div class="panel-body">
            <form action="{{ URL::to('product/search') }}" method="post" class="form-inline">
                {{ csrf_field() }}
                <input type="text" name="q" class="form-control" placeholder="...">
                <button type="submit" class="btn btn-primary"> Search </button>
            </form>
        
            <a href="{{ URL::to('product/edit/') }}" class="btn btn-success pull-right">Add product</a>

            <table class="table table-bordered bs_table">
                <thead>
                    <tr>
                        <th> Product picture </th>
                        <th> Product Id </th>
                        <th> Product name </th>
                        <th> Product type </th>
                        <th> Product left </th>
                        <th> Product price </th>
                        <th> Product use </th>
                    </tr>
                </thead>
                <tbody>
                    @foreach ($products as $p)
                        <tr>
                            <td><img src="{{ $p->image_url }}" width="50px"></td>
                            <td>{{ $p->code }}</td>
                            <td>{{ $p->name }}</td>
                            <td>{{ $p->category->name }}</td>
                            <td class="bs_price">{{ number_format($p->stock_qty, 0) }}</td>
                            <td class="bs_price">{{ number_format($p->price, 2) }}</td>
                            <td class="bs_center">
                                <a href="{{ URL::to('product/edit/'.$p->id) }}" class="btn btn-info"><i class="fa fa-edit"> Edit </i></a>
                                <a href="#" class="btn btn-delete btn-danger" id-delete="{{ $p->id }}">
                                    <i class="fa fa-trash"> Delete </i>
                                </a>
                            </td>
                        </tr>
                    @endforeach
                </tbody>
                <tfoot>
                    <tr>
                        <th colspan="4"> All </th>
                        <th class="bs_price">{{ number_format($products->sum('stock_qty'), 0) }}</th>
                        <th class="bs_price">{{ number_format($products->sum('price'), 2) }}</th>
                    </tr>
                </tfoot>
            </table>

        </div>

        <div class="panel-footer">
            <div class="container">
                {{$products->links()}}
            </div>
            <span>have {{ count($products)}} list</span>
        </div>

        <script>
            // ใช้เทคนิค jQuery
            $('.btn-delete').on('click', function() { if(confirm("คุณต้องการลบข้อมูลสินค้าหรือไม่?")) {
            var url = "{{ URL::to('product/remove') }}"
            + '/' + $(this).attr('id-delete'); window.location.href = url;
            }
            });
        </script>

    </div>
@endsection