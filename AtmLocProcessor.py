# Don't forget to install requests package

import requests
import json

atmId = '0x56c66be5a73e492741506f56L'
apiKey = 'ff49a2f8b4b6fcd5ea8883d568bc85f0'




for i in range(0,800):
   url = 'http://api.reimaginebanking.com/atms/{}?key={}'.format(atmId[2:-1],apiKey)
   hex_int = int(atmId[2:-1], 16) - 1
   atmId = hex(hex_int)
   response = requests.get(
       url,
       headers={'content-type':'application/json'},
    )
   if response.status_code == 200:
    print(response.content[response.content.index('lng'):response.content.index(',"access')])
