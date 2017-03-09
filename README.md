# FancyDialog
A customisable AlertDialog for Android.
<img src="https://raw.githubusercontent.com/ahmadnajar10/fancyDialog/master/device-2017-03-08-171007.png">


## Add Library
```
repositories {
        jcenter()
    }
       

compile 'com.geniusforapp.countries:countries:0.0.1'

```
## Code Sample
```
  CountriesDialog.Builder builder = new CountriesDialog.Builder(this).setOnCountrySelectedListener(new CountriesDialog.OnCountrySelectedListener() {
            @Override
            public void OnCountry(EntityCountry c, Dialog dialog) {
                Toast.makeText(BaseActivity.this, c.toString(), Toast.LENGTH_SHORT).show();
            }
        }).build();
        builder.show();
                
                
```

### Pull requests are welcome!

Feel free to contribute to CountrySelector.

If you've fixed a bug or have a feature you've added, just create a pull request. If you've found a bug, want a new feature, or have other questions, file an issue. I will try to answer as soon as possible.

### Applications using CountrySelector

Please send a pull request if you would like to be added here.

## License
Copyright 2017 Ahmad Najar

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
