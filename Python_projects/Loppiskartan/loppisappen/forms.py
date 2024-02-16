from django import forms


class CreateNewMarketAd(forms.Form):
    datetime = forms.DateTimeField(label='Tid och plats')
    title = forms.CharField(label='Titel', max_length=120)
    desc = forms.CharField(label='Beskrivning', max_length=470, required=False)
    location = forms.CharField(label='Plats', max_length=255)
    #Make this multiple choice
    category = forms.CharField(label='Kategori', max_length=120)
    #Get from cookies
    user_id = forms.CharField(label='Säljar Id', max_length=12)


class AddUser(forms.Form):
    username = forms.CharField(max_length=120)
    user_first_name = forms.CharField(max_length=155)
    user_last_name = forms.CharField(max_length=155)
