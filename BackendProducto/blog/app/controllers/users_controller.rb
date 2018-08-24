class UsersController < ApplicationController
    def index
        #con el modelo post, busque los post ordenelos por la fecha que creo automaticamente
        @users = User.order('created_at DESC')

    end

end
