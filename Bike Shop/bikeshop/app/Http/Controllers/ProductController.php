<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Product;
use Config,Validator;
use App\Models\Category;
class ProductController extends Controller
{
    var $rp = 2;

    public function __construct()
    {
        //$this->rp = Config::get('app.result_per_page');
    }

    public function index()
    {
        $products = Product::paginate($this->rp);
        return view('product/index', compact('products'));
    }

    public function search(Request $request)
    {
        $query = $request->q;
        if($query)
        {
            $products = Product::where('name', 'like', '%'.$query.'%')
            ->orWhere('code', 'like', '%'.$query.'%')
            ->paginate($this->rp);
        }
        
        else
        {
            $products = Product::paginate($this->rp);
        }
        
        return view('product/index', compact('products'));
    }
    
    public function edit($id = null)
    {
        $categories = Category::pluck('name', 'id')->prepend('Select list', '');
        if($id)
        {
            //edit view
            $product = Product::where('id', $id)->first();

            return view('product/edit')
            ->with('product', $product)
            ->with('categories', $categories);
        }
        
        else
        {
            return view('product/add')
            ->with('categories', $categories);
        }
       
    }

    public function update(Request $request) 
    {
        $rules = array(
            'Product id' => 'required',
            'Product name' => 'required',
            'Product category' => 'required|numeric', 
            'Product price' => 'numeric',
            'Product left' => 'numeric',
        );

        $messages = array(
            'required' => 'Please input information in :attribute ', 
            'numeric' => 'Please input information in
            :attribute as number',
        );
            
        $id = $request->id;

        $temp = array(
            'Product id' => $request->code,
            'Product name' => $request->name,
            'Product category' => $request->category_id,
            'Product price' => $request->price,
            'Product left' => $request->stock_qty,
        );

        $validator = Validator::make($temp, $rules, $messages);

        if ($validator->fails()) 
        {
            return redirect('product/edit/'.$id)
            ->withErrors($validator)
            ->withInput();
        }
        
        $product = Product::find($id);
        $product->code = $request->code;
        $product->name = $request->name;
        $product->category_id = $request->category_id;
        $product->price = $request->price;
        $product->stock_qty = $request->stock_qty;

        $product->save();

        if($request->hasFile('image'))
        {
          
            $f = $request->file('image');
            $upload_to = 'upload/image'; //แปลว่า คุณต้องไปสร้างโฟลเดอร์ชื่อนี้ไว้ในโปรเจคคุณด้วยนะ
            // get path
            $relative_path = $upload_to.'/'.$f->getClientOriginalName();
            $absolute_path = public_path().'/'.$upload_to;
            // upload file
            $f->move($absolute_path, $f->getClientOriginalName());
            // save image path to database
            $product->image_url = $relative_path;
        }

        return redirect('product')
        ->with('ok', true)
        ->with('msg', 'Save Successfully');
    }

    public function insert(Request $request)
    {

        $rules = array(
            'Product id' => 'required',
            'Product name' => 'required',
            'Product category' => 'required|numeric', 
            'Product price' => 'numeric',
            'Product left' => 'numeric',
        );

        $messages = array(
            'required' => 'Please input information in :attribute ', 
            'numeric' => 'Please input information in
            :attribute as number',
        );
            
        $id = $request->id;

        $temp = array(
            'Product id' => $request->code,
            'Product name' => $request->name,
            'Product category' => $request->category_id,
            'Product price' => $request->price,
            'Product left' => $request->stock_qty,
        );

        $validator = Validator::make($temp, $rules, $messages);

        if ($validator->fails()) 
        {
            return redirect('product/edit/'.$id)
            ->withErrors($validator)
            ->withInput();
        }

        $product = new Product();
        $product->code = $request->code;
        $product->name = $request->name;
        $product->category_id = $request->category_id;
        $product->price = $request->price;
        $product->stock_qty = $request->stock_qty;

        $product->save();

        if($request->hasFile('image'))
        {
          
            $f = $request->file('image');
            $upload_to = 'upload/image'; //แปลว่า คุณต้องไปสร้างโฟลเดอร์ชื่อนี้ไว้ในโปรเจคคุณด้วยนะ
            // get path
            $relative_path = $upload_to.'/'.$f->getClientOriginalName();
            $absolute_path = public_path().'/'.$upload_to;
            // upload file
            $f->move($absolute_path, $f->getClientOriginalName());
            // save image path to database
            $product->image_url = $relative_path;
        }

        return redirect('product')
        ->with('ok', true)
        ->with('msg', 'Save Successfully');
    }

    public function remove($id) 
    {
        Product::find($id)->delete();
        return redirect('product')
        ->with('ok', true)
        ->with('msg', 'Delete successfully');
    }
    
}
