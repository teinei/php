<!--
// -----------------------------------------------------------------------------
// Globals
function printSnd()
{
newWindow = open("","","width=300,height=100,toolbar = 0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1")
var myStyle = langDir == 'rtl' ? 'style = "font-size:110%;font-weight:bold"': ''
cTbl = xid('id_anc').getElementsByTagName( 'TABLE' )
eval( gi_w_lib.get_source() )
wl( '<html>' )
wl( '<head>' )
wl( '</head>' )
wl( '<body style="font-size:90%;">' )
wl( '<div style="overflow:auto;padding:3px;">' )
wl( '<p align = "right" style="font-size:125%">', langName, '</p>' )
wl( '<h3>Pronunciation Guide</h3><br />' )
wl( '<table width="95%" border="1" cellpadding="3px" style="border-collapse: collapse;" bordercolor="#111111" align="center">' )
wl( '  <tr>' )
wl( '    <th width="25%" align="left">LIKE</th>' )
wl( '    <th width="75%" align="left">AS IN</th>' )
wl( '  </tr>' )
for( var i=0; i<cTbl.length; i++)
  {
  var R = cTbl[i]
  var rr = R.rows.length
  for( var j=0; j<rr; j++ )
    {
    if( R.rows[j].cells.length > 1)
      {
      wl( '  <tr>' )
      wl( '    <td valign="top">' )
      wl( '    ', R.rows[j].cells[1].innerHTML, '</td>' )
      wl( '    <td valign="top">' )
      wl( '    ', R.rows[j].cells[4].innerHTML, '</td>' )
      wl( '  </tr>' )
      }
    }
  }
wl( '</table>' )
wl( '</div>' )
wl( '</body>' )
wl( '<html>' )
newWindow.document.open()
newWindow.document.write(wr)
newWindow.document.close()
if(confirm("Do you really want to print this page?"))
  {
  newWindow.print()
  newWindow.close()
  }
else
  newWindow.close()
}

function printPg( langName, langDir ) 
{ 
newWindow = open("","","width=600,height=300,toolbar = 0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1") 
var myStyle = langDir == 'rtl' ? 'style = "font-weight:bold"': '' 
cTbl = xid('id_anc').getElementsByTagName( 'TABLE' ) 
eval( gi_w_lib.get_source() ) 
wl( '<html>' ) 
wl( '<head>' ) 
wl( '</head>' ) 
wl( '<body>' ) 
wl( '<div style="overflow:auto;padding:3px;">' ) 
wl( '<p align = "right">', langName, '</p>' ) 
wl( '<h3>', cTbl[0].id, '</h3><br />' ) 
wl( '<table width="95%" border="1" cellpadding="3" style="border-collapse: collapse;" bordercolor="#111111" align="center">' ) 
wl( '  <tr>' ) 
wl( '    <th width="50%" align="center">ENGLISH</th>' ) 
wl( '    <th width="50%" align="center">TRANSLITERATION <br /> (TARGET LANGUAGE)</th>' ) 
wl( '  </tr>' ) 
for( var i=0; i<cTbl.length; i++) 
  { 
  var R = cTbl[i]  
  var rr = R.rows.length  
  for( var j=0; j<rr; j++ ) 
    { 
    if( R.rows[j].cells.length > 6) 
      { 
      wl( '  <tr>' ) 
      wl( '    <td  valign="top" dir="">' ) 
      wl( '    ', R.rows[j].cells[1].innerHTML, '</td>' ) 
      wl( '    <td valign="top" dir="', langDir, '" >' ) 
      wl( '<p dir="ltr">',R.rows[j].cells[4].innerHTML, '</p>( <span ', myStyle, '>  ', R.rows[j].cells[6].innerHTML, ' </span> )</td>' ) 
      wl( '  </tr>' ) 
      }  
    } 
  } 
wl( '</table>' ) 
wl( '</div>' ) 
wl( '</body>' ) 
wl( '<html>' ) 
newWindow.document.open() 
newWindow.document.write(wr) 
newWindow.document.close() 
if(confirm("Do you really want to print this page?")) 
  { 
  newWindow.print() 
  newWindow.close() 
  } 
else 
  newWindow.close() 
} 
// -->

