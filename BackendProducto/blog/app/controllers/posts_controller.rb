class PostsController < ApplicationController
    def index
        #con el modelo post, busque los post ordenelos por la fecha que creo automaticamente
        @posts = Post.order('created_at DESC')

    end
    def show
        #con el modelo post, busque los post ordenelos por la fecha que creo automaticamente
        @post = Post.find(params[:id])

    end
end
