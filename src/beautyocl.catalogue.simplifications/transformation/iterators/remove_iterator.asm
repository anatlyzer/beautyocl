<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="remove_iterator"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchtrueSelect():V"/>
		<constant value="__exec__"/>
		<constant value="trueSelect"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applytrueSelect(NTransientLink;):V"/>
		<constant value="isTrue"/>
		<constant value="MOCL!OclExpression;"/>
		<constant value="8:60-8:65"/>
		<constant value="MOCL!BooleanExp;"/>
		<constant value="0"/>
		<constant value="booleanSymbol"/>
		<constant value="9:60-9:64"/>
		<constant value="9:60-9:78"/>
		<constant value="__matchtrueSelect"/>
		<constant value="IteratorExp"/>
		<constant value="OCL"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="select"/>
		<constant value="J.=(J):J"/>
		<constant value="body"/>
		<constant value="J.isTrue():J"/>
		<constant value="J.and(J):J"/>
		<constant value="B.not():B"/>
		<constant value="37"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="it"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="a"/>
		<constant value="DeleteMoveChildren"/>
		<constant value="ACT"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="13:3-13:5"/>
		<constant value="13:3-13:10"/>
		<constant value="13:13-13:21"/>
		<constant value="13:3-13:21"/>
		<constant value="13:26-13:28"/>
		<constant value="13:26-13:33"/>
		<constant value="13:26-13:42"/>
		<constant value="13:3-13:42"/>
		<constant value="15:5-15:31"/>
		<constant value="__applytrueSelect"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="source"/>
		<constant value="children"/>
		<constant value="17:3-17:4"/>
		<constant value="17:15-17:17"/>
		<constant value="17:3-17:18"/>
		<constant value="18:3-18:4"/>
		<constant value="18:17-18:19"/>
		<constant value="18:17-18:26"/>
		<constant value="18:3-18:27"/>
		<constant value="16:2-19:3"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<pushf/>
		</code>
		<linenumbertable>
			<lne id="47" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="48"/>
		<parameters>
		</parameters>
		<code>
			<load arg="49"/>
			<get arg="50"/>
		</code>
		<linenumbertable>
			<lne id="51" begin="0" end="0"/>
			<lne id="52" begin="0" end="1"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="53">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="54"/>
			<push arg="55"/>
			<findme/>
			<push arg="56"/>
			<call arg="57"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="38"/>
			<push arg="58"/>
			<call arg="59"/>
			<load arg="19"/>
			<get arg="60"/>
			<call arg="61"/>
			<call arg="62"/>
			<call arg="63"/>
			<if arg="64"/>
			<getasm/>
			<get arg="1"/>
			<push arg="65"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="66"/>
			<dup/>
			<push arg="67"/>
			<load arg="19"/>
			<pcall arg="68"/>
			<dup/>
			<push arg="69"/>
			<push arg="70"/>
			<push arg="71"/>
			<new/>
			<pcall arg="72"/>
			<pusht/>
			<pcall arg="73"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="74" begin="7" end="7"/>
			<lne id="75" begin="7" end="8"/>
			<lne id="76" begin="9" end="9"/>
			<lne id="77" begin="7" end="10"/>
			<lne id="78" begin="11" end="11"/>
			<lne id="79" begin="11" end="12"/>
			<lne id="80" begin="11" end="13"/>
			<lne id="81" begin="7" end="14"/>
			<lne id="82" begin="29" end="34"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="67" begin="6" end="36"/>
			<lve slot="0" name="17" begin="0" end="37"/>
		</localvariabletable>
	</operation>
	<operation name="83">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="84"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="67"/>
			<call arg="85"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="69"/>
			<call arg="86"/>
			<store arg="87"/>
			<load arg="87"/>
			<pop/>
			<load arg="87"/>
			<load arg="29"/>
			<set arg="88"/>
			<load arg="87"/>
			<load arg="29"/>
			<get arg="88"/>
			<set arg="89"/>
		</code>
		<linenumbertable>
			<lne id="82" begin="8" end="9"/>
			<lne id="90" begin="10" end="10"/>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="10" end="12"/>
			<lne id="93" begin="13" end="13"/>
			<lne id="94" begin="14" end="14"/>
			<lne id="95" begin="14" end="15"/>
			<lne id="96" begin="13" end="16"/>
			<lne id="97" begin="10" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="69" begin="7" end="16"/>
			<lve slot="2" name="67" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="98" begin="0" end="16"/>
		</localvariabletable>
	</operation>
</asm>
